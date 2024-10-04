package ru.rinat.project3.filters;

import org.springframework.data.jpa.domain.Specification;
import ru.rinat.project3.models.Measurement;

public record MeasurementIsRainyFilter() {
    public Specification<Measurement> toSpecification() {
        return Specification.where(rainingTrueSpec());
    }

    private Specification<Measurement> rainingTrueSpec() {
        return ((root, query, cb) -> cb.isTrue(root.get("raining")));
    }
}