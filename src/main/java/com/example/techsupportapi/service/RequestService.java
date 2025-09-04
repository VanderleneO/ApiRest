package com.example.techsupportapi.service;

import java.util.List;
import java.util.Optional;

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

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Optional<Request> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }

    public Request updateRequest(Long id, Request updatedRequest) {
        return requestRepository.findById(id)
                .map(request -> {
                    request.setTitle(updatedRequest.getTitle());
                    request.setDescription(updatedRequest.getDescription());
                    request.setStatus(updatedRequest.getStatus());
                    request.setAssignee(updatedRequest.getAssignee());
                    return requestRepository.save(request);
                })
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con id: " + id));
    }

    // Nuevo método para la eliminación de una solicitud
    public void deleteRequest(Long id) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            if ("Atendida".equals(request.getStatus())) {
                requestRepository.delete(request);
            } else {
                throw new IllegalArgumentException("No se puede eliminar una solicitud en estado 'Pendiente'.");
            }
        } else {
            throw new RuntimeException("Solicitud no encontrada con id: " + id);
        }
    }
}
