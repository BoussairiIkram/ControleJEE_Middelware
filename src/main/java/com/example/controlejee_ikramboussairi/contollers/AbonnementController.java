package com.example.controlejee_ikramboussairi.contollers;

import com.example.controlejee_ikramboussairi.entities.Abonnement;
import com.example.controlejee_ikramboussairi.entities.Client;

import com.example.controlejee_ikramboussairi.repositories.AbonnementRepository;
import com.example.controlejee_ikramboussairi.repositories.ClientRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class AbonnementController {

    Long id_Client;

    @Autowired
    private AbonnementRepository abonnementRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/user/abonnement")
    public String abonnementRessources(Model model,@RequestParam Long id){

        List<Abonnement> abonnements = abonnementRepository.findAbonnementsByClient_Id(id);
        model.addAttribute("listAbonnement", abonnements);

         id_Client = id;

        return "abonnement";
    }


    @PostMapping("/admin/saveAbonnement")
    public String saveAbonnement(Model model, @Valid Abonnement abonnement,@RequestParam Long clientId, BindingResult bindingResult){
        Client client = clientRepository.findById(clientId).orElse(null);

        if(client!=null) abonnement.setClient(client);

        abonnementRepository.save(abonnement);
        return "redirect:/user/abonnement?id="+clientId;
    }


    @GetMapping("/admin/editAbonnement")
    public String editAbonnement(Model model,@RequestParam Long id){
        Abonnement abonnement = abonnementRepository.findById(id).orElse(null);
        if(abonnement==null) throw new RuntimeException("Abonnement introuvable");

        model.addAttribute("abonnement",abonnement);

        return "editAbonnement";
    }

    @GetMapping("/admin/formAbonnement")
    public String formRessources(Model model){
        Abonnement abonnement = new Abonnement();

        abonnement.setDateAbonnement(new Date());

        Client client = clientRepository.findById(id_Client).orElse(null);
        abonnement.setClient(client);

        model.addAttribute("abonnement", abonnement);
        return "formAbonnement";
    }

    @GetMapping("/admin/deleteAbonnement")
    public String deleteAbonnement(@RequestParam Long id){

        abonnementRepository.deleteById(id);
        return "redirect:/user/abonnement?id=" + id_Client;
    }

}
