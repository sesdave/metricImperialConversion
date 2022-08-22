package com.techserve.ImperialMetricConverter.controller;

import com.techserve.ImperialMetricConverter.model.RestResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConverterControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void test_convertMetricImperial(){
        RestResponse converterResponse = testRestTemplate.getForObject("http://localhost:"+port+"/api/convert?value=3.0&unit=celsius", RestResponse.class);
        Assertions.assertNotNull(converterResponse);

    }
}
