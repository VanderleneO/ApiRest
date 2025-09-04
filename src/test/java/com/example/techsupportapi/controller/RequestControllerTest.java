package com.example.techsupportapi.controller;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.techsupportapi.model.Request;
import com.example.techsupportapi.service.RequestService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RequestController.class)
public class RequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RequestService requestService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createRequest_ShouldReturnCreatedStatus() throws Exception {

        Request requestToSave = new Request();
        when(requestService.saveRequest(any(Request.class))).thenReturn(new Request());

        mockMvc.perform(post("/solicitudes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestToSave)))
                .andExpect(status().isCreated());
    }
}