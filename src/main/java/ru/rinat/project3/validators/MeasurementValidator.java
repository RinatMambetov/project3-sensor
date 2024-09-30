package ru.rinat.project3.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.rinat.project3.dto.MeasurementDto;
import ru.rinat.project3.models.Sensor;
import ru.rinat.project3.services.SensorService;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return MeasurementDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        MeasurementDto measurementDto = (MeasurementDto) target;
        String name = measurementDto.getSensor().getName();
        Optional<Sensor> sensor = sensorService.findByNameIgnoreCase(name);
        if (sensor.isEmpty()) {
            errors.rejectValue("sensor", "sensor.name",
                    "Sensor with name: " + name + " does not exist");
        }
    }
}
