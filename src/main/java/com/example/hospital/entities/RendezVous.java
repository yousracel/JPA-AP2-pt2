package com.example.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class RendezVous {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRdv status;
@ManyToOne
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient ;
@ManyToOne
    private  Medecin medecin ;
@OneToOne(mappedBy = "rendezVous" , fetch= FetchType.LAZY)
private Consultation consultation ;
}
