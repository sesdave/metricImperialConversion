package com.techserve.ImperialMetricConverter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestResponse {
    private String initVal;
    private String initunit;
    private String retVal;
    private String retunit;

}
