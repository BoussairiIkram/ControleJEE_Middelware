package com.example.controlejee_ikramboussairi.contollers;

import com.example.controlejee_ikramboussairi.entities.Abonnement;
import com.example.controlejee_ikramboussairi.entities.Client;
import com.example.controlejee_ikramboussairi.repositories.AbonnementRepository;
import com.example.controlejee_ikramboussairi.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AbonnementRepository abonnementRepository;

    @GetMapping("/user/index")
    public String ressources(Model model,
                             @RequestParam(name="page", defaultValue = "0") int page,
                             @RequestParam(name="size", defaultValue = "5") int size,
                             @RequestParam(name="keyword", defaultValue = "") String keyword){
        Page<Client> pageClient = clientRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listClient", pageClient.getContent());
        model.addAttribute("pages", new int[pageClient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return "client";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }

    @GetMapping("/admin/delete")
    public String delete(@RequestParam Long id, String keyword, int page){

        List<Abonnement> abonnements = abonnementRepository.findAbonnementsByClient_Id(id);
        for (Abonnement a : abonnements ) {
            abonnementRepository.delete(a);
        }

        clientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/formClient")
    public String formRessources(Model model){
        model.addAttribute("client", new Client());
        return "formClient";
    }

    @PostMapping("/admin/save")
    public String save(Model model, @Valid Client client, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formPatients";

        clientRepository.save(client);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editClient")
    public String editClient(Model model, Long id, String keyword, int page){
        Client client = clientRepository.findById(id).orElse(null);
        if(client==null) throw new RuntimeException("Patient introuvable");

        model.addAttribute("client",client);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);

        return "editClient";
    }

}
