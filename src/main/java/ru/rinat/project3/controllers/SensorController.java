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
import ru.rinat.project3.dto.SensorDto;
import ru.rinat.project3.exceptions.SensorNotCreatedException;
import ru.rinat.project3.mappers.SensorMapper;
import ru.rinat.project3.models.Sensor;
import ru.rinat.project3.services.SensorService;
import ru.rinat.project3.utils.Helper;
import ru.rinat.project3.validators.SensorValidator;

@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorServiceImpl;
    private final SensorValidator sensorValidator;

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid SensorDto sensorDto,
                                             BindingResult bindingResult) {

        sensorValidator.validate(sensorDto, bindingResult);
        if (bindingResult.hasErrors()) {
            String errorMsg = Helper.getMsg(bindingResult);
            throw new SensorNotCreatedException(errorMsg);
        }

        Sensor sensor = SensorMapper.INSTANCE.toEntity(sensorDto);
        sensorServiceImpl.create(sensor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

