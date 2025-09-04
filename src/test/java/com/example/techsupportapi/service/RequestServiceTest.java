package com.example.techsupportapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.techsupportapi.model.Request;
import com.example.techsupportapi.repository.RequestRepository;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {

    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private RequestService requestService;

    @Test
    void saveRequest_ShouldReturnSavedRequest() {

        Request requestToSave = new Request();
        requestToSave.setThemeRequest("Problema de red");

        Request savedRequest = new Request();
        savedRequest.setId(1L);
        savedRequest.setThemeRequest("Problema de red");

        when(requestRepository.save(any(Request.class))).thenReturn(savedRequest);

        Request result = requestService.saveRequest(requestToSave);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Problema de red", result.getThemeRequest());
        verify(requestRepository, times(1)).save(requestToSave);
    }
}