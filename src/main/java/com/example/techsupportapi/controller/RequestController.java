package com.example.techsupportapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techsupportapi.model.Request;
import com.example.techsupportapi.service.RequestService;

/**
 * El controlador REST que maneja las peticiones HTTP.
 * Se encarga de recibir las peticiones y enviar las respuestas.
 * Delega toda la logica de negocio a la capa de servicio.
 */
@RestController
@RequestMapping("/solicitudes")
public class RequestController {

    private final RequestService requestService;

    // Inyeccion de dependencia del servicio.
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    /**
     * Endpoint para crear una nueva solicitud.
     * Maneja la peticion POST a /solicitudes.
     * 
     * @param newRequest El cuerpo de la solicitud en formato JSON.
     * @return La solicitud creada con un codigo de estado 201 Created.
     */
    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody Request newRequest) {
        try {
            Request createdRequest = requestService.createRequest(newRequest);
            return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para obtener todas las solicitudes.
     * Maneja la peticion GET a /solicitudes.
     * 
     * @return Una lista de todas las solicitudes.
     */
    @GetMapping
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    /**
     * Endpoint para obtener la lista de temas de consulta.
     * Maneja la peticion GET a /solicitudes/temas-consulta.
     * 
     * @return Una lista de temas de consulta.
     */
    @GetMapping("/temas-consulta")
    public List<String> getTopics() {
        return requestService.getTopics();
    }
}
