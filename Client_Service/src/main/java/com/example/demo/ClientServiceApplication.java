package com.example.demo;

import com.example.demo.Entities.Client;
import com.example.demo.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start (ClientRepository clientRepository){
        return args->{
           clientRepository.save(new Client(1,"user1","user","user1@user.com"));
           clientRepository.save(new Client(2,"user2","user","user2@user.com"));
        };
    }
}
