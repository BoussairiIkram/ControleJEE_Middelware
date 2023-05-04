package com.example.controlejee_ikramboussairi.dto.responses;

import com.example.controlejee_ikramboussairi.entities.TypeAbonnement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbonnementResponseDTO {
    private Long id;
    private Date dateAbonnement;
    private Double soldeAbonnement;
    private Double montantMensuel;
    private TypeAbonnement typeAbonnement;
    private Long clientId;
}
