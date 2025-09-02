package com.example.techsupportapi.model;

import java.time.LocalDateTime;

/**
 * Clase de modelo que representa una solicitud de soporte.
 * Esta clase es mutable para permitir que el servicio y el repositorio le
 * asignen
 * un ID y una fecha de creacion.
 */
public class Request {
        private int id;
        private String applicantName;
        private LocalDateTime requestDate;
        private String topic;
        private String description;
        private String status;

        public Request() {
                // Constructor vacio para serializacion de JSON
        }

        // Constructor para la creacion inicial de la solicitud
        public Request(String applicantName, String topic, String description) {
                this.applicantName = applicantName;
                this.topic = topic;
                this.description = description;
        }

        // Getters y Setters
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getApplicantName() {
                return applicantName;
        }

        public void setApplicantName(String applicantName) {
                this.applicantName = applicantName;
        }

        public LocalDateTime getRequestDate() {
                return requestDate;
        }

        public void setRequestDate(LocalDateTime requestDate) {
                this.requestDate = requestDate;
        }

        public String getTopic() {
                return topic;
        }

        public void setTopic(String topic) {
                this.topic = topic;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }
}