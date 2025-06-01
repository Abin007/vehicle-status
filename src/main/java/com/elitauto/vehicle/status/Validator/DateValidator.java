package com.elitauto.vehicle.status.Validator;

import org.apache.coyote.BadRequestException;

public interface DateValidator {
    void isValid(String date) throws BadRequestException;
}
