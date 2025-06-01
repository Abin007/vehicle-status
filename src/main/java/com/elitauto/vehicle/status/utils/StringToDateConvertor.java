package com.elitauto.vehicle.status.utils;

import com.elitauto.vehicle.status.data.enums.Estimator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
public class StringToDateConvertor implements Converter<String, LocalDate> {
    final String pattern = "MM/dd/yyyy";
    @Override
    public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
        String sourceValue = mappingContext.getSource();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate;
        if (sourceValue != null) {
            try{
                return LocalDate.parse(sourceValue, formatter);
            }
            catch (DateTimeException e){
                log.error("Error parsing");
            }

        }
        return null;
    }
}
