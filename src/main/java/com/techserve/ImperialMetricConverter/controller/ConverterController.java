package com.techserve.ImperialMetricConverter.controller;

import com.techserve.ImperialMetricConverter.exception.IncompactibleUnitException;
import com.techserve.ImperialMetricConverter.model.RestResponse;
import com.techserve.ImperialMetricConverter.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConverterController {
    @Autowired
    ConverterService service;

    @GetMapping("/convert")
    public ResponseEntity<RestResponse> convertMetricImperial(@RequestParam Double value, @RequestParam String unit) throws IncompactibleUnitException {
        RestResponse valueToConvert=service.convertImperial(value, unit);
        System.out.println(valueToConvert);
        return new ResponseEntity(valueToConvert, HttpStatus.OK);
    }
}
