package com.app.myPsy_BE.service;

import com.app.myPsy_BE.entity.Utente;
import com.app.myPsy_BE.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository userRepository;

    public List<Utente> getAllUsers() {
        return userRepository.findAll();
    }

    public Utente getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Utente getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Utente save(Utente utente) {
        return userRepository.save(utente);
    }
}
