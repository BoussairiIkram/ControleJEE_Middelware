package com.example.controlejee_ikramboussairi.dto.mappers;

import com.example.controlejee_ikramboussairi.dto.responses.ClientResponseDTO;
import com.example.controlejee_ikramboussairi.entities.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientResponseDTO fromClient(Client client){
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        BeanUtils.copyProperties(client, clientResponseDTO);

        return  clientResponseDTO;
    }
}
