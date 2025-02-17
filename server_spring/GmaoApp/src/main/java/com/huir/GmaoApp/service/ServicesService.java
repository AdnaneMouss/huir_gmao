package com.huir.GmaoApp.service;

import com.huir.GmaoApp.model.Services;
import com.huir.GmaoApp.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {

    @Autowired
    private ServicesRepository serviceRepository;

    // Create or update a Services
    public Services saveService(Services Services) {
        return serviceRepository.save(Services);
    }

    // Find a Services by ID
    public Optional<Services> findServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    // Find a Services by name
    public Services findServiceByName(String name) {
        return serviceRepository.findByNom(name);
    }

    // Get all Servicess
    public List<Services> findAllServices() {
        return serviceRepository.findAll();
    }

    // Delete a Services
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
