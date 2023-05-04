package com.example.controlejee_ikramboussairi.services.serviceImp;

import com.example.controlejee_ikramboussairi.dto.mappers.AbonnementMapper;
import com.example.controlejee_ikramboussairi.dto.requests.AbonnementRequestDTO;
import com.example.controlejee_ikramboussairi.dto.responses.AbonnementResponseDTO;
import com.example.controlejee_ikramboussairi.entities.Abonnement;
import com.example.controlejee_ikramboussairi.repositories.AbonnementRepository;
import com.example.controlejee_ikramboussairi.repositories.ClientRepository;
import com.example.controlejee_ikramboussairi.services.AbonnementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor @Transactional
public class AbonnementServiceImp implements AbonnementService {

    private AbonnementRepository abonnementRepository;
    private AbonnementMapper abonnementMapper;
    private ClientRepository clientRepository;

    @Override
    public AbonnementResponseDTO addAbonnement(AbonnementRequestDTO abonnementRequestDTO, Long id) {
        Abonnement abonnement = new Abonnement();
        abonnement.setDateAbonnement(abonnementRequestDTO.getDateAbonnement());
        abonnement.setTypeAbonnement(abonnementRequestDTO.getTypeAbonnement());
        abonnement.setSoldeAbonnement(abonnementRequestDTO.getSoldeAbonnement());
        abonnement.setMontantMensuel(abonnementRequestDTO.getMontantMensuel());
        abonnement.setClient(clientRepository.findById(id).orElse(null));

        Abonnement abonnementsaved = abonnementRepository.save(abonnement);

        return abonnementMapper.fromAbonnement(abonnementsaved,id);
    }

    @Override
    public AbonnementResponseDTO updateAbonnement(Long id, AbonnementRequestDTO abonnementRequestDTO) {
        Abonnement abonnement = abonnementRepository.findById(id).orElse(null);
        if(abonnement!=null){
            if(abonnementRequestDTO.getDateAbonnement()!=null) abonnement.setDateAbonnement(abonnementRequestDTO.getDateAbonnement());
            if(abonnementRequestDTO.getTypeAbonnement()!=null) abonnement.setTypeAbonnement(abonnementRequestDTO.getTypeAbonnement());
            if(abonnementRequestDTO.getSoldeAbonnement()!=null) abonnement.setSoldeAbonnement(abonnementRequestDTO.getSoldeAbonnement());
            if(abonnementRequestDTO.getMontantMensuel()!=null) abonnement.setMontantMensuel(abonnementRequestDTO.getMontantMensuel());
        }

        Abonnement abonnementUpdated = abonnementRepository.save(abonnement);
        return abonnementMapper.fromAbonnement(abonnementUpdated, abonnement.getClient().getId());
    }

    @Override
    public AbonnementResponseDTO getAbonnement(Long id) {
        Abonnement abonnement = abonnementRepository.findById(id).orElse(null);

        return abonnementMapper.fromAbonnement(abonnement,abonnement.getClient().getId());
    }

    @Override
    public List<AbonnementResponseDTO> getAbonnementsClient(Long idClient) {
        List<Abonnement> abonnements =  abonnementRepository.findAbonnementsByClient_Id(idClient);
        List<AbonnementResponseDTO> ResponseDTOS = new ArrayList<>();

        for (Abonnement a:abonnements){
            AbonnementResponseDTO abonnementResponseDTO = new AbonnementResponseDTO();
            abonnementResponseDTO = abonnementMapper.fromAbonnement(a, a.getClient().getId());
            ResponseDTOS.add(abonnementResponseDTO);
        }


        return ResponseDTOS;
    }

    @Override
    public void deleteAbonnement(Long id) {
        abonnementRepository.deleteById(id);
    }
}
