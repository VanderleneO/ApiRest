package com.example.techsupportapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.techsupportapi.model.Request;
import com.example.techsupportapi.repository.RequestRepository;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request createRequest(Request request) {
        request.setRequestDate(LocalDateTime.now());
        request.setStatus("Pendiente");
        return requestRepository.save(request);
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Optional<Request> getRequestById(Integer id) {
        return requestRepository.findById(id);
    }

    public Optional<Request> markAsAttended(Integer id, String attendedBy) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setStatus("Atendida");
            request.setAttendedBy(attendedBy);
            request.setAttendedAt(LocalDateTime.now());
            request.setLastEditedAt(LocalDateTime.now());
            requestRepository.save(request);
        }
        return optionalRequest;
    }
}
