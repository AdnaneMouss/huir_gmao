package com.huir.GmaoApp.repository;

import com.huir.GmaoApp.model.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
    Equipement findByNumeroSerie(String numeroSerie);
}
