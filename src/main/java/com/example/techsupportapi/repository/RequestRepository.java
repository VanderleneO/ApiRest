package com.example.techsupportapi.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.example.techsupportapi.model.Request;

/**
 * Repositorio que simula una base de datos en memoria para las solicitudes.
 * Maneja las operaciones de persistencia.
 */
@Repository
public class RequestRepository {

    // Simula una base de datos en memoria
    private final List<Request> requests = new ArrayList<>();

    // Generador de IDs secuenciales
    private final AtomicInteger counter = new AtomicInteger(0);

    /**
     * Guarda una nueva solicitud en el "almacenamiento" y le asigna un ID.
     * 
     * @param request La solicitud a guardar.
     * @return La solicitud guardada con el ID asignado.
     */
    public Request save(Request request) {
        request.setId(counter.incrementAndGet());
        request.setRequestDate(LocalDateTime.now());
        request.setStatus("Pendiente");
        this.requests.add(request);
        return request;
    }

    /**
     * Busca todas las solicitudes guardadas.
     * 
     * @return Una lista de todas las solicitudes.
     */
    public List<Request> findAll() {
        return new ArrayList<>(this.requests);
    }
}
