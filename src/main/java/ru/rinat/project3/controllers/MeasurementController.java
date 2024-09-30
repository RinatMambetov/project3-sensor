package ru.rinat.project3.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rinat.project3.dto.MeasurementDto;
import ru.rinat.project3.exceptions.MeasurementNotCreatedException;
import ru.rinat.project3.mappers.MeasurementMapper;
import ru.rinat.project3.models.Measurement;
import ru.rinat.project3.models.Sensor;
import ru.rinat.project3.services.MeasurementService;
import ru.rinat.project3.services.SensorService;
import ru.rinat.project3.utils.Helper;
import ru.rinat.project3.validators.MeasurementValidator;

import java.util.Optional;

@RestController
@RequestMapping("/measurements")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;
    private final SensorService sensorService;
    private final MeasurementValidator measurementValidator;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid MeasurementDto measurementDto,
                                             BindingResult bindingResult) {

        measurementValidator.validate(measurementDto, bindingResult);
        if (bindingResult.hasErrors()) {
            String errorMsg = Helper.getMsg(bindingResult);
            throw new MeasurementNotCreatedException(errorMsg);
        }

        Measurement measurement = MeasurementMapper.INSTANCE.toEntity(measurementDto);
        Optional<Sensor> sensor = sensorService.findByNameIgnoreCase(measurementDto.getSensor().getName());
        sensor.ifPresent(measurement::setSensor);
        measurementService.create(measurement);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
