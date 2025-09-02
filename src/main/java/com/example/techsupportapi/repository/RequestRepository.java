package com.example.techsupportapi.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.example.techsupportapi.model.Request;

@Repository
public class RequestRepository {
    private static final List<Request> requests = new ArrayList<>();
    private static final AtomicInteger counter = new AtomicInteger();

    public Request save(Request newRequest) {
        if (newRequest.getId() == null) {
            newRequest.setId(counter.incrementAndGet());
            requests.add(newRequest);
        } else {
            requests.stream()
                    .filter(request -> request.getId().equals(newRequest.getId()))
                    .findFirst()
                    .ifPresent(existingRequest -> {
                        existingRequest.setApplicantName(newRequest.getApplicantName());
                        existingRequest.setTopic(newRequest.getTopic());
                        existingRequest.setDescription(newRequest.getDescription());
                        existingRequest.setStatus(newRequest.getStatus());
                        existingRequest.setAttendedBy(newRequest.getAttendedBy());
                        existingRequest.setAttendedAt(newRequest.getAttendedAt());
                        existingRequest.setLastEditedAt(newRequest.getLastEditedAt());
                    });
        }
        return newRequest;
    }

    public List<Request> findAll() {
        requests.sort(Comparator.comparing(Request::getRequestDate));
        return new ArrayList<>(requests);
    }

    public Optional<Request> findById(Integer id) {
        return requests.stream()
                .filter(request -> request.getId().equals(id))
                .findFirst();
    }
}
