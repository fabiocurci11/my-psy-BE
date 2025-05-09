package com.app.myPsy_BE.controller;

import com.app.myPsy_BE.entity.Utente;
import com.app.myPsy_BE.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UtenteController {

    @Autowired
    private UtenteService userService;

    @GetMapping("/{username}")
    public ResponseEntity<Utente> getUser(@PathVariable String username) {
        System.out.println("Get user " + username);
        Utente utente = userService.getUserByUsername(username);
        return utente != null ? ResponseEntity.ok(utente) : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Utente> createUser(@RequestBody Utente utente) {
        System.out.println("Utente: "+utente.toString());
        Utente savedUser = userService.save(utente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Utente>> getAllUsers() {
        List<Utente> utenti = userService.getAllUsers();
        return ResponseEntity.ok(utenti);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utente> updateUser(@PathVariable Long id, @RequestBody Utente updatedUser) {
        Utente existingUser = userService.getUserById(id);
        if (existingUser == null) {
            System.out.println("L'utente da aggiornare non esiste");
            return ResponseEntity.notFound().build();
        }

        if (updatedUser.getUsername() != null) {
            existingUser.setUsername(updatedUser.getUsername());
        }

        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }

        Utente savedUser = userService.save(existingUser);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
