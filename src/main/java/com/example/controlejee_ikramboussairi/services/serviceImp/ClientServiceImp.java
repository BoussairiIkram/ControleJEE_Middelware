package com.example.controlejee_ikramboussairi.services.serviceImp;

import com.example.controlejee_ikramboussairi.dto.mappers.ClientMapper;
import com.example.controlejee_ikramboussairi.dto.requests.ClientRequestDTO;
import com.example.controlejee_ikramboussairi.dto.responses.ClientResponseDTO;
import com.example.controlejee_ikramboussairi.entities.Abonnement;
import com.example.controlejee_ikramboussairi.entities.Client;
import com.example.controlejee_ikramboussairi.repositories.AbonnementRepository;
import com.example.controlejee_ikramboussairi.repositories.ClientRepository;
import com.example.controlejee_ikramboussairi.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional @AllArgsConstructor
public class ClientServiceImp implements ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    private AbonnementRepository abonnementRepository;

    @Override
    public ClientResponseDTO addClient(ClientRequestDTO clientRequestDTO) {
        Client client = new Client();
        client.setNom(clientRequestDTO.getNom());
        client.setUsername(clientRequestDTO.getUsername());
        client.setEmail(clientRequestDTO.getEmail());

        Client saveClinet = clientRepository.save(client);

        return clientMapper.fromClient(saveClinet);
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {

        Client client = clientRepository.findById(id).orElse(null);
        if(client!=null){
            if(clientRequestDTO.getNom()!=null) client.setNom(clientRequestDTO.getNom());
            if(clientRequestDTO.getUsername()!=null) client.setUsername(clientRequestDTO.getUsername());
            if(clientRequestDTO.getEmail()!=null) client.setEmail(clientRequestDTO.getEmail());
        }

        Client clientUpdated = clientRepository.save(client);

        return clientMapper.fromClient(clientUpdated);
    }

    @Override
    public ClientResponseDTO getClient(Long id) {
        Client client = clientRepository.findById(id).orElse(null);

        return clientMapper.fromClient(client);
    }

    @Override
    public List<ClientResponseDTO> getClients() {
        List<Client> clients = clientRepository.findAll();

        List<ClientResponseDTO> responseDTOS =  new ArrayList<>();

        for(Client c : clients){
            ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
            clientResponseDTO = clientMapper.fromClient(c);
            responseDTOS.add(clientResponseDTO);
        }
        return responseDTOS;
    }

    @Override
    public void deleteClient(Long id) {
        List<Abonnement> abonnements = abonnementRepository.findAbonnementsByClient_Id(id);
        for (Abonnement a : abonnements ) {
            abonnementRepository.delete(a);
        }
        clientRepository.deleteById(id);
    }
}
