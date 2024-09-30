package ru.rinat.project3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rinat.project3.models.Sensor;
import ru.rinat.project3.repositories.SensorRepository;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    public void create(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    public boolean isExist(Sensor sensor) {
        return sensorRepository.findByName(sensor.getName()).isPresent();
    }
}
