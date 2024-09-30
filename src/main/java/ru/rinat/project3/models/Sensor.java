package ru.rinat.project3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(message = "Name must be between 3 and 30 characters", min = 3, max = 30)
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Measurement> measurements;

    public Sensor(String name) {
        this.name = name;
    }
}
