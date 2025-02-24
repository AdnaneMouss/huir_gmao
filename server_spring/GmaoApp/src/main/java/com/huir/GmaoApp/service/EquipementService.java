package com.huir.GmaoApp.service;

import com.huir.GmaoApp.model.Equipement;
import com.huir.GmaoApp.repository.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    // Create or update an equipment
    public Equipement saveEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    // Find an equipment by ID
    public Optional<Equipement> findEquipementById(Long id) {
        return equipementRepository.findById(id);
    }

    // Find an equipment by serial number
    public Equipement findEquipementBySerialNumber(String serialNumber) {
        return equipementRepository.findByNumeroSerie(serialNumber);
    }

    // Get all equipment
    public List<Equipement> findAllEquipements() {
        return equipementRepository.findAll();
    }

    // Delete an equipment
    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }
}
