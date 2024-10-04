package ru.rinat.project3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rinat.project3.dto.MeasurementDto;
import ru.rinat.project3.mappers.MeasurementMapper;
import ru.rinat.project3.models.Measurement;
import ru.rinat.project3.repositories.MeasurementRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    @Transactional
    public void create(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    public List<MeasurementDto> getList() {
        List<Measurement> measurements = measurementRepository.findAll();
        return measurements.stream()
                .map(measurementMapper::toDto)
                .toList();
    }
}
