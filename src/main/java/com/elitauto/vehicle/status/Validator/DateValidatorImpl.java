package com.elitauto.vehicle.status.Validator;

import org.apache.coyote.BadRequestException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidatorImpl implements DateValidator {
    private DateTimeFormatter dateFormatter;

    public DateValidatorImpl(DateTimeFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public void isValid(String date) throws BadRequestException {
        try {
            LocalDate.parse(date, this.dateFormatter);
        } catch (DateTimeParseException e) {
            throw new BadRequestException(date + "is invalid Date Format");
        }

    }
}
