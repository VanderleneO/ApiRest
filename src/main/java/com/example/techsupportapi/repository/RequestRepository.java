package com.example.techsupportapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techsupportapi.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
