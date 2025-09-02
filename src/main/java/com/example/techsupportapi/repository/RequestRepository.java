package com.example.techsupportapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.techsupportapi.model.Request;

@Repository
public class RequestRepository {
    private final List<Request> requests = new ArrayList<>();
    private long nextId = 1;

    public Request save(Request request) {
        request.setId(nextId++);
        requests.add(request);
        return request;
    }

    public List<Request> findAll() {
        return new ArrayList<>(requests);
    }
}
