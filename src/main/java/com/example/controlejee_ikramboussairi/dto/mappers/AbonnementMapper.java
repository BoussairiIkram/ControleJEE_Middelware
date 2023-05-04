package com.example.controlejee_ikramboussairi.dto.mappers;

import com.example.controlejee_ikramboussairi.dto.responses.AbonnementResponseDTO;
import com.example.controlejee_ikramboussairi.entities.Abonnement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AbonnementMapper {
    public AbonnementResponseDTO fromAbonnement(Abonnement abonnement,Long id){
        AbonnementResponseDTO abonnementResponseDTO = new AbonnementResponseDTO();
        abonnementResponseDTO.setClientId(id);
        BeanUtils.copyProperties(abonnement, abonnementResponseDTO);

        return  abonnementResponseDTO;
    }
}
