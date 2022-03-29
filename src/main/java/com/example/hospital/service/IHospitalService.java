package com.example.hospital.service;

import com.example.hospital.entities.* ;

public interface IHospitalService {
    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m) ;
    RendezVous saveRendezVous(RendezVous rdv) ;
    Consultation saveConsultation(Consultation c) ;

}
