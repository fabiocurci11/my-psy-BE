package com.app.myPsy_BE.controller;

import com.app.myPsy_BE.entity.Utente;
import com.app.myPsy_BE.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

    @Autowired
    private UtenteService service;

    @GetMapping
    public List<Utente> listaUtenti() {
        return service.findAllUser();
    }

    @PostMapping
    public Utente creaUtente(@RequestBody Utente utente) {
        return service.save(utente);
    }
}
