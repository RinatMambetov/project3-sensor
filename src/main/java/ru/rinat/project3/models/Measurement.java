package ru.rinat.project3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Max(message = "Value can't be greater than 100", value = 100)
    @Min(message = "Value can't be less than -100", value = -100)
    @NotNull(message = "Value can't be null")
    @Column(name = "value", nullable = false)
    private Double value;

    @NotNull(message = "Raining can't be null")
    @Column(name = "raining", nullable = false)
    private Boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    @NotNull(message = "Time can't be null")
    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    public Measurement(Double value, Boolean raining, Sensor sensor, LocalDateTime time) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
        this.time = time;
    }
}
