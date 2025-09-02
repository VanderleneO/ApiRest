package com.example.techsupportapi.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.techsupportapi.model.Request;
import com.example.techsupportapi.repository.RequestRepository;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    // Lista predefinida de temas
    private static final List<String> PREDEFINED_TOPICS = Arrays.asList(
            "Redes",
            "Hardware",
            "Software",
            "Seguridad",
            "Acceso a Correo Electrónico",
            "Impresoras");

    public Request createRequest(Request request) {
        request.setRequestDate(LocalDateTime.now());
        request.setStatus("Pendiente");
        return requestRepository.save(request);
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll().stream()
                .sorted(Comparator.comparing(Request::getRequestDate))
                .collect(Collectors.toList());
    }

    public List<String> getTopics() {
        return PREDEFINED_TOPICS;
    }
}
