package com.example.controlejee_ikramboussairi.repositories;

import com.example.controlejee_ikramboussairi.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Page<Client> findByNomContains(String keyword, Pageable pageable);

}
