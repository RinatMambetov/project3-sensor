package ru.rinat.project3.exceptions;

public class MeasurementNotCreatedException extends RuntimeException {
    public MeasurementNotCreatedException(String errorMsg) {
        super(errorMsg);
    }
}
