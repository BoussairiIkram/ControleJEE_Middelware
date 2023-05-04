package com.example.controlejee_ikramboussairi;

import com.example.controlejee_ikramboussairi.entities.Abonnement;
import com.example.controlejee_ikramboussairi.entities.Client;
import com.example.controlejee_ikramboussairi.entities.TypeAbonnement;
import com.example.controlejee_ikramboussairi.repositories.AbonnementRepository;
import com.example.controlejee_ikramboussairi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class ControleJeeIkramBoussairiApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	AbonnementRepository abonnementRepository;

	public static void main(String[] args) {
		SpringApplication.run(ControleJeeIkramBoussairiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	clientRepository.save(new Client(null,"ikram","ikram@gmail.com","ikramUser",null));
		clientRepository.save(new Client(null,"imane","imane@gmail.com","imaneUser",null));
		clientRepository.save(new Client(null,"afaf","afaf@gmail.com","afaUser",null));
		clientRepository.save(new Client(null,"saad","saad@gmail.com","saadUser",null));
		clientRepository.save(new Client(null,"ikram","ikram@gmail.com","ikramUser",null));
		clientRepository.save(new Client(null,"imane","imane@gmail.com","imaneUser",null));
		clientRepository.save(new Client(null,"afaf","afaf@gmail.com","afaUser",null));
		clientRepository.save(new Client(null,"saad","saad@gmail.com","saadUser",null));


		Client client1 = clientRepository.findById(5L).orElse(null);
		Client client2 = clientRepository.findById(6L).orElse(null);

		abonnementRepository.save(new Abonnement(null, new Date(),901.5,30100, TypeAbonnement.GSM,client1));
		abonnementRepository.save(new Abonnement(null, new Date(),801.5,50600, TypeAbonnement.INTERNET,client2));
		abonnementRepository.save(new Abonnement(null, new Date(),301.5,170600, TypeAbonnement.TELEPHONE_FIXE,client2));
		abonnementRepository.save(new Abonnement(null, new Date(),401.5,600, TypeAbonnement.INTERNET,client1));

*/
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
