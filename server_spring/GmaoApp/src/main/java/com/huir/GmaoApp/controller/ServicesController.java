package com.huir.GmaoApp.controller;

import com.huir.GmaoApp.model.Services;
import com.huir.GmaoApp.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    @Autowired
    private ServicesService serviceService;

    // Get all services
    @GetMapping
    public List<Services> getAllServices() {
        return serviceService.findAllServices();
    }

    // Get service by ID
    @GetMapping("/{id}")
    public ResponseEntity<Services> getServiceById(@PathVariable Long id) {
        Optional<Services> service = serviceService.findServiceById(id);
        return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update service
    @PostMapping
    public ResponseEntity<Services> createService(@RequestBody Services service) {
        Services savedService = serviceService.saveService(service);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedService);
    }

    // Delete service
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
