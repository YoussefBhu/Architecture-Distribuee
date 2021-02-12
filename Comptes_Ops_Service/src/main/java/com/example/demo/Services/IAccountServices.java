package com.example.demo.Services;

import com.example.demo.Entities.Compte;
import com.example.demo.Entities.Operation;

import java.util.List;

public interface IAccountServices  {
    public Compte AjouterCompte(Compte compte);
    public void Verser(Double montant,Long id);
    public void retrait(Double montant,Long id);
    public List<Operation> GetOperations(Long id);
    public Compte GetCompte(Long id);
    public void Activer(Long id);
}
