package com.example.demo.Services;

import com.example.demo.Entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CLIENT-SERVICE")
public interface ClientService {
    @GetMapping("/clients/{id}")
    Client findClientById(@PathVariable("id") Long id);
}
