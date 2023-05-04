package com.example.controlejee_ikramboussairi.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {
    private Long id;
    private String nom;
    private String username;
    private String email;
}
