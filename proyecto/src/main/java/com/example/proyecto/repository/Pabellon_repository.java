package com.example.proyecto.repository;

import com.example.proyecto.model.Pabellon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Pabellon_repository extends CrudRepository<Pabellon,Long> {
    Iterable <Pabellon> findAllByestado(String estado);
    Pabellon deleteById(long id);
}