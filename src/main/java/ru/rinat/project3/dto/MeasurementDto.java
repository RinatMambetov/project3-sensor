package ru.rinat.project3.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.rinat.project3.models.Measurement;
import ru.rinat.project3.models.Sensor;

/**
 * DTO for {@link Measurement}
 */
@Getter
@Setter
@ToString
public class MeasurementDto {

    @NotNull(message = "Value can't be null")
    @Min(message = "Value can't be less than -100", value = -100)
    @Max(message = "Value can't be greater than 100", value = 100)
    private Double value;

    @NotNull(message = "Raining can't be null")
    private Boolean raining;

    private Sensor sensor;

}
