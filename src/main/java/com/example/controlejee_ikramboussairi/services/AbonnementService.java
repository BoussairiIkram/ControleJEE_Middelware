package com.example.controlejee_ikramboussairi.services;

import com.example.controlejee_ikramboussairi.dto.requests.AbonnementRequestDTO;
import com.example.controlejee_ikramboussairi.dto.responses.AbonnementResponseDTO;

import java.util.List;

public interface AbonnementService {

    AbonnementResponseDTO addAbonnement(AbonnementRequestDTO abonnementRequestDTO, Long id);

    AbonnementResponseDTO updateAbonnement(Long id, AbonnementRequestDTO abonnementRequestDTO);

    AbonnementResponseDTO getAbonnement( Long id);

    List<AbonnementResponseDTO> getAbonnementsClient(Long id);

    void deleteAbonnement(Long id);
}
