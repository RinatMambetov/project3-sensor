package ru.rinat.project3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rinat.project3.models.Sensor;
import ru.rinat.project3.repositories.SensorRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    @Transactional
    public void create(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    public boolean isExist(Sensor sensor) {
        return sensorRepository.findByNameIgnoreCase(sensor.getName()).isPresent();
    }

    public Optional<Sensor> findByNameIgnoreCase(String name) {
        return sensorRepository.findByNameIgnoreCase(name);
    }
}
