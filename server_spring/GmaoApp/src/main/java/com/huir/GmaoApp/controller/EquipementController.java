package com.huir.GmaoApp.controller;

import com.huir.GmaoApp.dto.EquipementDTO;
import com.huir.GmaoApp.model.Equipement;
import com.huir.GmaoApp.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipements")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipementController {

    @Autowired
    private EquipementService equipementService;

    // Get all equipment
    @GetMapping
    public List<EquipementDTO> getAllEquipements() {
        return equipementService.findAllEquipements().stream()
                .map(EquipementDTO::new)
                .collect(Collectors.toList());
    }

    // Get equipment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        Optional<Equipement> equipement = equipementService.findEquipementById(id);
        return equipement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update equipment
    @PostMapping
    public ResponseEntity<Equipement> createEquipement(@RequestBody Equipement equipement) {
        Equipement savedEquipement = equipementService.saveEquipement(equipement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipement);
    }

    // Delete equipment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        equipementService.deleteEquipement(id);
        return ResponseEntity.noContent().build();
    }
}
