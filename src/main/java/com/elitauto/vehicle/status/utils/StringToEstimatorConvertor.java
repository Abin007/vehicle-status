package com.elitauto.vehicle.status.utils;

import com.elitauto.vehicle.status.data.enums.Estimator;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class StringToEstimatorConvertor implements Converter<String, Estimator> {
    @Override
    public Estimator convert(MappingContext<String, Estimator> mappingContext) {
        String sourceValue = mappingContext.getSource();
        if (sourceValue != null) {
            return Estimator.valueOf(sourceValue.toUpperCase());
        }
        return null;
    }
}
