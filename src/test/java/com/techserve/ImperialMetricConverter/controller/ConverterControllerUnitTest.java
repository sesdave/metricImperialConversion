package com.techserve.ImperialMetricConverter.controller;

import com.techserve.ImperialMetricConverter.exception.IncompactibleUnitException;
import com.techserve.ImperialMetricConverter.model.RestResponse;
import com.techserve.ImperialMetricConverter.service.ConverterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest
class ConverterControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ConverterService converterService;

    @Test
    void convertMetricImperial() throws Exception {
        Mockito.when(converterService.convertImperial(3.1, "celcius")).thenReturn(new RestResponse("","","", ""));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/convert?value=3.0&unit=celsius")
                                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}