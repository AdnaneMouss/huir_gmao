import {Service} from "./service";
import {User} from "./user";
import {OrdreTravail} from "./ordre-travail";
import {PieceDetachee} from "./piece-detachee";

export interface Equipement {
  id: number;
  nom: string;
  description: string;
  numeroSerie: string;
  modele: string;
  image: string;
  marque: string;
  localisation: string;
  service: Service;  // Lien vers un service, tu devras définir ce modèle aussi
  statut: 'EN_SERVICE' | 'EN_REPARATION' | 'HORS_SERVICE';  // Valeurs directement dans l'attribut
  dateAchat: string;  // Peut être une chaîne ou un objet Date en fonction de ce que tu préfères
  dateMiseEnService: string;
  garantie: string;
  dateDerniereMaintenance: string;
  frequenceMaintenance: string;
  responsableMaintenance: User | null;  // Lien vers l'utilisateur responsable de la maintenance
  ordresTravail: OrdreTravail[];  // Liste des ordres de travail, tu devras définir ce modèle aussi
  piecesDetachees: PieceDetachee[];  // Liste des pièces détachées, tu devras définir ce modèle aussi
  historiquePannes?: string;  // Optionnel
  coutAchat?: string;  // Optionnel, selon ta préférence pour String ou BigDecimal
}
