package ru.rinat.project3.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.rinat.project3.dto.SensorDto;
import ru.rinat.project3.models.Sensor;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    SensorMapper INSTANCE = Mappers.getMapper(SensorMapper.class);

    @Mapping(target = "measurements", ignore = true)
    @Mapping(target = "id", ignore = true)
    Sensor toEntity(SensorDto sensorDto);
}
