package com.example.demo.Services;

import com.example.demo.Entities.Client;
import com.example.demo.Entities.Compte;
import com.example.demo.Entities.Operation;
import com.example.demo.Repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("Comptes")
public class AccountServices implements IAccountServices {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private ClientService clientService;

    @Override
    @PostMapping
    public Compte AjouterCompte(@RequestBody Compte compte) {
        compte.setDateCreation(new Date());
        return compteRepository.save(compte);
    }

    public Supplier<Operation> kafkaverser(Operation operation){
        return ()-> operation;
    }

    public Supplier<Operation> kafkaRetrait(Operation operation){
        return ()-> operation;
    }
    @Override
    @PostMapping("Verser/{Id}")
    public void Verser(@RequestBody Double montant,@PathVariable("Id") Long id) {
        Compte c = compteRepository.findById(id).get();
        c.setSold(c.getSold()+montant);
        Operation o = new Operation(null, new Date(), montant, "versment",null);
        c.getOperationList().add(o);
        compteRepository.save(c);
        kafkaverser(o);
    }

    @Override
    @PostMapping("Retrait/{Id}")
    public void retrait(@RequestBody Double montant,@PathVariable("Id") Long id) {
        Compte c = compteRepository.findById(id).get();
        c.setSold(c.getSold()-montant);
        Operation o = new Operation(null, new Date(), montant, "versment",null);
        c.getOperationList().add(o);
        compteRepository.save(c);
        kafkaRetrait(o);
    }

    @Override
    @GetMapping("/{Id}/Operations")
    public List<Operation> GetOperations(@PathVariable("Id")  Long id) {
        return compteRepository.getOne(id).getOperationList();
    }

    @Override
    @GetMapping("/{Id}")
    public Compte GetCompte(@PathVariable("Id") Long id) {
        Compte compte = compteRepository.getOne(id);
        Client client = clientService.findClientById(compte.getClientId());
        compte.setClient(client);
        compte.setOperationList(new ArrayList<>());
        return compte;
    }

    @Override
    @PostMapping("Active/{Id}")
    public void Activer(@PathVariable("Id") Long id) {
        Compte compte =  compteRepository.getOne(id);
        compte.setActive(!compte.isActive());
    }
}
