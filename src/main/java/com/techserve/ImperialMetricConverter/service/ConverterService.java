package com.techserve.ImperialMetricConverter.service;

import com.techserve.ImperialMetricConverter.exception.IncompactibleUnitException;
import com.techserve.ImperialMetricConverter.model.RestResponse;
import com.techserve.ImperialMetricConverter.util.ImperialMetricConverter;
import com.techserve.ImperialMetricConverter.util.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {
    @Autowired
    private ImperialMetricConverter metricConverter;

    public RestResponse convertImperial(double value, String unit) throws IncompactibleUnitException {
        Unit convert_from = metricConverter.getUnit(unit);
        Unit convert_to = metricConverter.getReturnUnit(unit);
        if(convert_from==null)throw new IncompactibleUnitException();
        double convalue = metricConverter.convert(value,convert_from, convert_to);
        return new RestResponse(convert_from.getName(), String.format("%.2f", value), convert_to.getName(), String.format("%.2f", convalue));
    }
}
