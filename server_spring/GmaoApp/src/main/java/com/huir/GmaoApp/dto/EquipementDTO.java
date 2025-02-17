package com.huir.GmaoApp.dto;

import com.huir.GmaoApp.model.Equipement;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipementDTO {
    private String image;
    private Long id;
    private String nom;
    private String description;
    private String numeroSerie;
    private String modele;
    private String marque;
    private String localisation;
    private String serviceNom;  // The service name instead of the full object
    private String statut;
    private String dateAchat;
    private String dateMiseEnService;
    private String garantie;
    private String dateDerniereMaintenance;
    private String frequenceMaintenance;
    private String responsableMaintenanceNom;  // The responsible maintenance name instead of the full object
    private List<String> ordresTravail;  // List of strings or specific references
    private List<String> piecesDetachees;  // List of strings or references for piecesDetachees
    private String historiquePannes;
    private String coutAchat;

    // Constructor to map Equipement to EquipementDTO
    public EquipementDTO(Equipement equipement) {
        this.id = equipement.getId();
        this.nom = equipement.getNom();
        this.description = equipement.getDescription();
        this.numeroSerie = equipement.getNumeroSerie();
        this.modele = equipement.getModele();
        this.marque = equipement.getMarque();
        this.localisation = equipement.getLocalisation();
        this.statut = equipement.getStatut();
        this.dateAchat = equipement.getDateAchat();
        this.dateMiseEnService = equipement.getDateMiseEnService();
        this.garantie = equipement.getGarantie();
        this.dateDerniereMaintenance = equipement.getDateDerniereMaintenance();
        this.frequenceMaintenance = equipement.getFrequenceMaintenance();
        this.historiquePannes = equipement.getHistoriquePannes();
        this.coutAchat = equipement.getCoutAchat();
        this.image=equipement.getImage();
        // Avoid circular reference
        this.serviceNom = equipement.getService() != null ? equipement.getService().getNom() : null;
        this.responsableMaintenanceNom = equipement.getResponsableMaintenance() != null ? equipement.getResponsableMaintenance().getNom() : null;

        // Convert list of ordresTravail to their names or references
        this.ordresTravail = equipement.getOrdresTravail() != null ? equipement.getOrdresTravail().stream()
                .map(ordre -> ordre.getDescription())  // assuming OrdreTravail has a "nom" field
                .collect(Collectors.toList()) : null;

        // Convert list of PieceDetachee to their names or references
        this.piecesDetachees = equipement.getPiecesDetachees() != null ? equipement.getPiecesDetachees().stream()
                .map(piece -> piece.getNom())  // assuming PieceDetachee has a "nom" field
                .collect(Collectors.toList()) : null;
    }
}
