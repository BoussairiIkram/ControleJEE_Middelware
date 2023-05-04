package com.example.controlejee_ikramboussairi.services;

import com.example.controlejee_ikramboussairi.dto.requests.ClientRequestDTO;
import com.example.controlejee_ikramboussairi.dto.responses.ClientResponseDTO;

import java.util.List;


public interface ClientService {
    ClientResponseDTO addClient(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO);

    ClientResponseDTO getClient(Long id);

    List<ClientResponseDTO> getClients();

    void deleteClient(Long id);
}
