package com.example.demo;

import com.example.demo.Entities.Client;
import com.example.demo.Entities.Compte;
import com.example.demo.Repositories.CompteRepository;
import com.example.demo.Services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class ComptesOpsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComptesOpsServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start (ClientService clientService, CompteRepository compteRepository){
        return args->{

        };
    }
}
