package ru.rinat.project3.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Helper {

    public static String getMsg(BindingResult bindingResult) {
        StringBuilder errorMsg = new StringBuilder();
        List<FieldError> allErrors = bindingResult.getFieldErrors();
        for (FieldError error : allErrors) {
            errorMsg.append(error.getField())
                    .append(" - ").append(error.getDefaultMessage())
                    .append("; ");
        }
        return errorMsg.toString();
    }

    public static String getCurrentFormattedTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
