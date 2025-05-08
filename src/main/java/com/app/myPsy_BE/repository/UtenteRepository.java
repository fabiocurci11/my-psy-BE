package com.app.myPsy_BE.repository;

import com.app.myPsy_BE.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}

