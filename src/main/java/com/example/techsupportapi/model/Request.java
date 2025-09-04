package com.example.techsupportapi.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Request {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private LocalDate dateRequest;
        private String themeRequest;
        private String description;

        // Getters y Setters
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public LocalDate getDateRequest() {
                return dateRequest;
        }

        public void setDateRequest(LocalDate dateRequest) {
                this.dateRequest = dateRequest;
        }

        public String getThemeRequest() {
                return themeRequest;
        }

        public void setThemeRequest(String themeRequest) {
                this.themeRequest = themeRequest;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}