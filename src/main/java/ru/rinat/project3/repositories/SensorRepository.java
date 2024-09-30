package ru.rinat.project3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rinat.project3.models.Sensor;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Optional<Sensor> findByNameIgnoreCase(String name);

}