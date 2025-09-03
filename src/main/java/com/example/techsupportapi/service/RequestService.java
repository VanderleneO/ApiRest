package com.example.techsupportapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.techsupportapi.model.Request;
import com.example.techsupportapi.repository.RequestRepository;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    private final AtomicLong counter = new AtomicLong();

    public Request createRequest(Request request) {
        request.setId(counter.incrementAndGet());
        request.setStatus("Pendiente");
        request.setRequestDate(LocalDateTime.now());
        return requestRepository.save(request);
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Optional<Request> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    public Optional<Request> editRequest(Long id, Request updatedRequest) {
        Optional<Request> existingRequestOpt = requestRepository.findById(id);
        if (existingRequestOpt.isPresent()) {
            Request existingRequest = existingRequestOpt.get();
            existingRequest.setTopic(updatedRequest.getTopic());
            existingRequest.setDescription(updatedRequest.getDescription());
            existingRequest.setLastEditedAt(LocalDateTime.now());
            return Optional.of(requestRepository.save(existingRequest));
        }
        return Optional.empty();
    }
}