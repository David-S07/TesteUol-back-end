package com.teste.uol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.uol.model.Incidente;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{

}
