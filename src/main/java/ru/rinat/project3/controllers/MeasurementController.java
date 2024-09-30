package ru.rinat.project3.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rinat.project3.dto.MeasurementDto;
import ru.rinat.project3.mappers.MeasurementMapper;
import ru.rinat.project3.models.Measurement;
import ru.rinat.project3.services.MeasurementService;

@RestController
@RequestMapping("/measurements")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid MeasurementDto measurementDto) {

        Measurement measurement = MeasurementMapper.INSTANCE.toEntity(measurementDto);
        measurementService.create(measurement);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

