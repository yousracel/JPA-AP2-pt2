package com.example.hospital;

import com.example.hospital.entities.*;
import com.example.hospital.repositories.ConsultationRepository;
import com.example.hospital.repositories.MedecinRepository;
import com.example.hospital.repositories.PatientRepository;
import com.example.hospital.repositories.RendezVousRepository;
import com.example.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService , PatientRepository patientRepository , MedecinRepository medecinRepository ,
                            RendezVousRepository rendezVousRepository ){
        return args ->{
            Stream.of("fatima" , " hamza" , " manal").forEach(name->
            {
                Patient p = new Patient() ;
                p.setNom(name);
                p.setDateNaissance(new Date());
                p.setMalade(false);
                hospitalService.savePatient(p) ;

            });
            Stream.of("khadija" , " yousra " , " anas ").forEach(name->
            {
                Medecin p = new Medecin() ;
                p.setNom(name);
               p.setEmail(name+"@gmail.com");
               p.setSpecialite(Math.random()>0.5?"cardio":"generaliste");
                hospitalService.saveMedecin(p) ;

            });
            Patient patient = patientRepository.findPatientByNom("fatima") ;
            Medecin medecin = medecinRepository.findMedecinByNom("yousra") ;
            RendezVous rdv = new RendezVous() ;
            rdv.setMedecin(medecin);
            rdv.setPatient(patient);
            rdv.setDate(new Date());
            rdv.setStatus(StatusRdv.PENDING);
            hospitalService.saveRendezVous(rdv) ;
            Consultation clt = new Consultation() ;
            RendezVous rdv1 = rendezVousRepository.findById(1L).orElse(null) ;
            clt.setRendezVous(rdv1);
            clt.setDateConsultation(new Date());

            clt.setRapport("rapport du rdv ");
            hospitalService.saveConsultation(clt) ;

        } ;
    }

}
