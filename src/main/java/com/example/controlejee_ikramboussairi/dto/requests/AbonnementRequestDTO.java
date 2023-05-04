package com.example.controlejee_ikramboussairi.dto.requests;

import com.example.controlejee_ikramboussairi.entities.TypeAbonnement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AbonnementRequestDTO {

    private Date dateAbonnement;
    private Double soldeAbonnement;
    private Double montantMensuel;
    private TypeAbonnement typeAbonnement;
}
