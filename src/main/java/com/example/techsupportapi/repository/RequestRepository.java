package com.example.techsupportapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.techsupportapi.model.Request;

@Repository
public class RequestRepository {

    private final List<Request> requests = new ArrayList<>();

    public Request save(Request request) {
        if (request.getId() != null) {
            Optional<Request> existingRequestOpt = findById(request.getId());
            if (existingRequestOpt.isPresent()) {
                Request existingRequest = existingRequestOpt.get();
                existingRequest.setApplicantName(request.getApplicantName());
                existingRequest.setTopic(request.getTopic());
                existingRequest.setDescription(request.getDescription());
                existingRequest.setLastEditedAt(request.getLastEditedAt());
                return existingRequest;
            }
        }
        requests.add(request);
        return request;
    }

    public List<Request> findAll() {
        return requests;
    }

    public Optional<Request> findById(Long id) {
        return requests.stream()
                .filter(request -> request.getId().equals(id))
                .findFirst();
    }
}