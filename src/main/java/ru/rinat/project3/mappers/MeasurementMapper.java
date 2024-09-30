package ru.rinat.project3.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.rinat.project3.dto.MeasurementDto;
import ru.rinat.project3.models.Measurement;

@Mapper
public interface MeasurementMapper {
    MeasurementMapper INSTANCE = Mappers.getMapper(MeasurementMapper.class);

    @Mapping(target = "time", ignore = true)
    @Mapping(target = "id", ignore = true)
    Measurement toEntity(MeasurementDto measurementDto);
}