package com.example.controlejee_ikramboussairi.repositories;

import com.example.controlejee_ikramboussairi.entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    List<Abonnement> findAbonnementsByClient_Id(Long id);

}
