package com.example.controlejee_ikramboussairi.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String username;
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<Abonnement> abonnements;
}
