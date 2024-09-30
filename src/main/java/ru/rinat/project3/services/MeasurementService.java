package ru.rinat.project3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rinat.project3.models.Measurement;
import ru.rinat.project3.repositories.MeasurementRepository;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    public void create(Measurement measurement) {
        measurementRepository.save(measurement);
    }
}
