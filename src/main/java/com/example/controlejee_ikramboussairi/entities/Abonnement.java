package com.example.controlejee_ikramboussairi.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Abonnement {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date dateAbonnement;
    private double soldeAbonnement;
    private double montantMensuel;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;

    @ManyToOne
    @JoinColumn(name="clientId")
    private Client client;


}
