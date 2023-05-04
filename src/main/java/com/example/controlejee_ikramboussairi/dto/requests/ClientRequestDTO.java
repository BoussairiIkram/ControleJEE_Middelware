package com.example.controlejee_ikramboussairi.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class ClientRequestDTO {
    private String nom;
    private String username;
    private String email;
}
