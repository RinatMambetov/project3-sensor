package ru.rinat.project3.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SensorNotCreatedException.class)
    public ResponseEntity<String> handleSensorNotCreatedException(SensorNotCreatedException ex) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = now.format(formatter);

        String message = String.format("Error: %s | Time: %s", ex.getMessage(), formattedTime);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}

