package ru.rinat.project3.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.rinat.project3.dto.SensorDto;
import ru.rinat.project3.mappers.SensorMapper;
import ru.rinat.project3.models.Sensor;
import ru.rinat.project3.services.SensorService;

@Component
@RequiredArgsConstructor
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return SensorDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        SensorDto sensorDto = (SensorDto) target;
        Sensor sensor = SensorMapper.INSTANCE.toEntity(sensorDto);
        if (sensorService.isExist(sensor)) {
            errors.rejectValue("name", "error.name",
                    "Sensor with this name already exists");
        }
    }
}
