package ru.rinat.project3.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.rinat.project3.exceptions.MeasurementNotCreatedException;
import ru.rinat.project3.exceptions.SensorNotCreatedException;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SensorNotCreatedException.class)
    public ResponseEntity<String> handleSensorNotCreatedException(SensorNotCreatedException ex) {
        String formattedTime = Helper.getCurrentFormattedTime();
        String message = String.format("Error: %s | Time: %s", ex.getMessage(), formattedTime);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MeasurementNotCreatedException.class)
    public ResponseEntity<String> handleMeasurementNotCreatedException(MeasurementNotCreatedException ex) {
        String formattedTime = Helper.getCurrentFormattedTime();
        String message = String.format("Error: %s | Time: %s", ex.getMessage(), formattedTime);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}

