package ru.rinat.project3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import ru.rinat.project3.models.Sensor;

/**
 * DTO for {@link ru.rinat.project3.models.Sensor}
 */
@Setter
@Getter
public class SensorDto {

    @NotNull(message = "Name cannot be null")
    @Size(message = "Name must be between 3 and 30 characters", min = 3, max = 30)
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    public Sensor toModel() {
        return new Sensor(name);
    }
}
