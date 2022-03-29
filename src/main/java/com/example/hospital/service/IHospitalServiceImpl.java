package com.example.hospital.service;

import com.example.hospital.entities.Consultation;
import com.example.hospital.entities.Medecin;
import com.example.hospital.entities.Patient;
import com.example.hospital.entities.RendezVous;
import com.example.hospital.repositories.ConsultationRepository;
import com.example.hospital.repositories.MedecinRepository;
import com.example.hospital.repositories.PatientRepository;
import com.example.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository ;
    private MedecinRepository medecinRepository ;
    private RendezVousRepository rendezVousRepository ;
    private ConsultationRepository consultationRepository ;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;

    }


    @Override
    public Patient savePatient(Patient p) { return  patientRepository.save(p) ; }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rdv) {
        return rendezVousRepository.save(rdv);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consultationRepository.save(c);
    }
}
