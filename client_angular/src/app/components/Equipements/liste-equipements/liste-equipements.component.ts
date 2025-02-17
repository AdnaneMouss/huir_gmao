import {Component, OnInit} from '@angular/core';
import {Equipement} from "../../../models/equipement";
import {EquipementService} from "../../../services/equipement.service";

@Component({
  selector: 'app-liste-equipements',
  templateUrl: './liste-equipements.component.html',
  styleUrl: './liste-equipements.component.css'
})
export class ListeEquipementsComponent implements OnInit {
  equipements: Equipement[] = [];
  newEquipement: Equipement = {
    id: 0,
    nom: '',
    description: '',
    image: '',
    numeroSerie: '',
    modele: '',
    marque: '',
    localisation: '',
    service: {id: 0, name: '', description: ''},  // Exemple de service
    statut: 'EN_SERVICE',
    dateAchat: new Date().toISOString(),
    dateMiseEnService: new Date().toISOString(),
    garantie: '',
    dateDerniereMaintenance: new Date().toISOString(),
    frequenceMaintenance: '',
    responsableMaintenance: null,  // Exemple d'utilisateur responsable
    ordresTravail: [],
    piecesDetachees: [],
  };
  showPanel = false;

  constructor(private equipementService: EquipementService) { }

  ngOnInit(): void {
    this.fetchEquipements();
  }

  fetchEquipements(): void {
    this.equipementService.getAllEquipements().subscribe({
      next: (data) => {
        this.equipements = data;
        console.log(this.equipementService.getAllEquipements())
      },
      error: (err) => {
        console.error('Error fetching equipements:', err);
      }
    });
  }

  addEquipement(): void {
    this.equipementService.createEquipement(this.newEquipement).subscribe({
      next: () => {
        alert('Equipement ajouté avec succès.');
        this.fetchEquipements();
        this.resetNewEquipement();
        this.showPanel = false;
      },
      error: (err) => {
        console.error('Error adding equipement:', err);
      }
    });
  }

  resetNewEquipement(): void {
    this.newEquipement = {
      id: 0,
      nom: '',
      description: '',
      image:'',
      numeroSerie: '',
      modele: '',
      marque: '',
      localisation: '',
      service: {id: 0, name: '', description: ''},
      statut: 'EN_SERVICE',
      dateAchat: new Date().toISOString(),
      dateMiseEnService: new Date().toISOString(),
      garantie: '',
      dateDerniereMaintenance: new Date().toISOString(),
      frequenceMaintenance: '',
      responsableMaintenance: null,
      ordresTravail: [],
      piecesDetachees: [],
    };
  }

  togglePanel(): void {
    this.showPanel = !this.showPanel;
  }

  deleteEquipement(id: number): void {
    if (confirm(`Êtes-vous sûr de vouloir supprimer l'équipement avec l'ID ${id}?`)) {
      this.equipementService.deleteEquipement(id).subscribe({
        next: () => {
          this.fetchEquipements();
          alert('Equipement supprimé avec succès.');
        },
        error: (err) => {
          console.error('Error deleting equipement:', err);
        }
      });
    }
  }
}
