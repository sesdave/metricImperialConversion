package com.techserve.ImperialMetricConverter.exception;

import lombok.Getter;

public class IncompactibleUnitException extends Exception{

    public IncompactibleUnitException(String message) {
        super(message);
    }

    public IncompactibleUnitException() {
        super();
    }

}
