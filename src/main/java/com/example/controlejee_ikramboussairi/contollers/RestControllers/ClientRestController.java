package com.example.controlejee_ikramboussairi.contollers.RestControllers;

import com.example.controlejee_ikramboussairi.dto.requests.ClientRequestDTO;
import com.example.controlejee_ikramboussairi.dto.responses.ClientResponseDTO;

import com.example.controlejee_ikramboussairi.services.ClientService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class ClientRestController {
    private ClientService clientService;

    @PostMapping("/clients")
    public ClientResponseDTO saveClient(@RequestBody ClientRequestDTO clientRequestDTO){

        return  clientService.addClient(clientRequestDTO);

    }

    @GetMapping("/clients")
    public List<ClientResponseDTO> getclients(){
        List<ClientResponseDTO> clients = clientService.getClients();
        return  clients;
    }

    @GetMapping("/clients/{id}")
    public ClientResponseDTO getClient(@PathVariable Long id){
        ClientResponseDTO client = clientService.getClient(id);
        return  client;
    }

    @PostMapping("/clients/{id}")
    public ClientResponseDTO updateClient(@PathVariable Long id,@RequestBody ClientRequestDTO clientRequestDTO){

        return clientService.updateClient(id,clientRequestDTO) ;
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

}
