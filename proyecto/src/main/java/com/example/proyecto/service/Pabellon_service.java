package com.example.proyecto.service;


import com.example.proyecto.model.Pabellon;
import com.example.proyecto.repository.Pabellon_repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class Pabellon_service {
    @Autowired
    private Pabellon_repository pab_repository;
    
    public Pabellon SaveOrUpdatePabellon(Pabellon pabellon) {
        return pab_repository.save(pabellon);
    }

    public Pabellon deletePabellon(long id) {
        return pab_repository.deleteById(id);
    }

    public Iterable <Pabellon> listAll(){
        return pab_repository.findAll();
    }

    public Iterable<Pabellon> obtenerporEstado(String estado) {
        return pab_repository.findAllByestado(estado);
    }

    public Optional<Pabellon> obtenerporId(final long id) {
        return pab_repository.findById((long) id);
    }
    
    public Pabellon obtenerporpaciente(final long id) {
        return pab_repository.findById_paciente((long) id);
    }

}