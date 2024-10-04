package ru.rinat.project3.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.rinat.project3.dto.MeasurementDto;
import ru.rinat.project3.models.Measurement;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {
    MeasurementMapper INSTANCE = Mappers.getMapper(MeasurementMapper.class);

    @Mapping(target = "sensor", source = "sensorDto")
    @Mapping(target = "time", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", ignore = true)
    Measurement toEntity(MeasurementDto measurementDto);

    @InheritInverseConfiguration(name = "toEntity")
    MeasurementDto toDto(Measurement measurement);

}
