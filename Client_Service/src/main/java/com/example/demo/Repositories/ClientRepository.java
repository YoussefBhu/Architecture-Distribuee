package com.example.demo.Repositories;

import com.example.demo.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
}
