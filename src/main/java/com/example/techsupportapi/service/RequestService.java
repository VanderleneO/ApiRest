package com.example.techsupportapi.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.techsupportapi.model.Request;
import com.example.techsupportapi.repository.RequestRepository;

/**
 * La capa de servicio que contiene toda la logica de negocio de la aplicacion.
 * El controlador llama a los metodos de esta clase para realizar operaciones.
 */
@Service
public class RequestService {

    private final RequestRepository requestRepository;

    private static final List<String> TOPICS = Arrays.asList(
            "Software",
            "Hardware",
            "Redes",
            "Seguridad",
            "Cuentas de usuario",
            "Otros");

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    /**
     * Valida y crea una nueva solicitud.
     * 
     * @param newRequest La solicitud entrante desde el controlador.
     * @return La solicitud creada.
     */
    public Request createRequest(Request newRequest) {
        // Validación de datos: asegura que los campos obligatorios no esten vacios.
        if (newRequest.getApplicantName() == null || newRequest.getApplicantName().trim().isEmpty() ||
                newRequest.getTopic() == null || newRequest.getTopic().trim().isEmpty() ||
                newRequest.getDescription() == null || newRequest.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre del solicitante, tema y descripcion son obligatorios.");
        }

        // Se guarda la solicitud en el repositorio
        return requestRepository.save(newRequest);
    }

    /**
     * Obtiene la lista de temas de consulta preestablecidos.
     * 
     * @return Una lista de temas.
     */
    public List<String> getTopics() {
        return TOPICS;
    }

    /**
     * Obtiene todas las solicitudes del repositorio.
     * 
     * @return Una lista de todas las solicitudes.
     */
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }
}
