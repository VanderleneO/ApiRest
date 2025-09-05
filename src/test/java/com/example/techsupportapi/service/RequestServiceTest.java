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
import com.example.techsupportapi.service.RequestService;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {

    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private RequestService requestService;

    @Test
    void saveRequest_ShouldReturnSavedRequest() {
        // Arrange
        Request requestToSave = new Request();
        requestToSave.setTitle("Problema de software");
        requestToSave.setDescription("La aplicación se cierra inesperadamente.");

        Request savedRequest = new Request();
        savedRequest.setId(1L);
        savedRequest.setTitle("Problema de software");
        savedRequest.setDescription("La aplicación se cierra inesperadamente.");

        when(requestRepository.save(any(Request.class))).thenReturn(savedRequest);

        // Act
        Request result = requestService.saveRequest(requestToSave);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Problema de software", result.getTitle());
        verify(requestRepository, times(1)).save(requestToSave);
    }
}