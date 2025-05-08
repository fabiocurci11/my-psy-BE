package com.app.myPsy_BE.service;

import com.app.myPsy_BE.entity.Utente;
import com.app.myPsy_BE.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository repository;

    public List<Utente> findAllUser() {
        return repository.findAll();
    }

    public Utente save(Utente utente) {
        return repository.save(utente);
    }
}
