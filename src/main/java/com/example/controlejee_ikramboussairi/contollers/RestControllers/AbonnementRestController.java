package com.example.controlejee_ikramboussairi.contollers.RestControllers;


import com.example.controlejee_ikramboussairi.dto.requests.AbonnementRequestDTO;
import com.example.controlejee_ikramboussairi.dto.responses.AbonnementResponseDTO;
import com.example.controlejee_ikramboussairi.services.AbonnementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class AbonnementRestController {

    private AbonnementService abonnementService;

    @PostMapping("/abonnements/{id}")
    public AbonnementResponseDTO saveAbonnement(@RequestBody AbonnementRequestDTO abonnementRequestDTO, @PathVariable Long id){

        return  abonnementService.addAbonnement(abonnementRequestDTO, id);

    }

    @GetMapping("/abonnementsClient/{idClient}")
    public List<AbonnementResponseDTO> getAbonnementsClient(@PathVariable Long idClient){
        List<AbonnementResponseDTO> abonnements = abonnementService.getAbonnementsClient(idClient);
        return  abonnements;
    }

    @GetMapping("/abonnement/{id}")
    public AbonnementResponseDTO getAbonnement(@PathVariable Long id){
        AbonnementResponseDTO abonnement = abonnementService.getAbonnement(id);
        return  abonnement;
    }

    @PostMapping("/abonnements/update/{id}")
    public AbonnementResponseDTO updateAbonnement(@PathVariable Long id,@RequestBody AbonnementRequestDTO abonnementRequestDTO){

        return abonnementService.updateAbonnement(id,abonnementRequestDTO) ;
    }

    @DeleteMapping("/abonnements/{id}")
    public void deleteAbonnement(@PathVariable Long id){
        abonnementService.deleteAbonnement(id);
    }

}
