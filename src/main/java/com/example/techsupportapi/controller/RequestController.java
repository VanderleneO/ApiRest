package com.example.techsupportapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techsupportapi.dto.UpdateAttendedByDTO;
import com.example.techsupportapi.model.Request;
import com.example.techsupportapi.service.RequestService;

@RestController
@RequestMapping("/solicitudes")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        Request newRequest = requestService.createRequest(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    @PatchMapping("/{id}/atendida")
    public ResponseEntity<Request> markAsAttended(@PathVariable Integer id, @RequestBody UpdateAttendedByDTO update) {
        Optional<Request> updatedRequest = requestService.markAsAttended(id, update.getAttendedBy());
        return updatedRequest.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
