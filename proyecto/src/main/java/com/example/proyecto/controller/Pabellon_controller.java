package com.example.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


import com.example.proyecto.model.Pabellon;
import com.example.proyecto.service.Pabellon_service;

@CrossOrigin
@RestController
@RequestMapping("/api/pabellon")
public class Pabellon_controller {

    @Autowired
    private Pabellon_service pab_service;

    @PostMapping("")
    public ResponseEntity<Pabellon> addPabellon (@RequestBody Pabellon pabellon){
        Pabellon pab = pab_service.SaveOrUpdatePabellon(pabellon);
        return new ResponseEntity<Pabellon>(pab,HttpStatus.CREATED);
    }

    @GetMapping("")
    public Iterable<Pabellon> getPabellones (){
        return pab_service.listAll();
    }

    @GetMapping("/estado")
    public Iterable<Pabellon> obtenerPabellon(@RequestParam(name = "estado") String estado) {
        return pab_service.obtenerporEstado(estado);
    }

    @GetMapping("/id")
    public Optional<Pabellon> obtenerPabellon_id(@RequestParam(name = "id") long id) {
        return pab_service.obtenerporId(id);
    }

    @PutMapping("/asignar")
    public ResponseEntity<Pabellon> asignar (@RequestBody Pabellon pabellon){
        Pabellon pabellon2 = pabellon;
        Optional <Pabellon> pabellon3 = pab_service.obtenerporId(pabellon2.getId());
        if(pabellon3.isPresent() == true){
            Pabellon pabellon4 = pabellon3.get();
            if(pabellon4.getEstado().equals("Ocupado")){
                return new ResponseEntity<Pabellon>(pabellon4,HttpStatus.CONFLICT);
            }
        }
        else{
            return new ResponseEntity<Pabellon>(pabellon,HttpStatus.CONFLICT);
        }
        pabellon2.setEstado("Ocupado");
        Pabellon pab = pab_service.SaveOrUpdatePabellon(pabellon2);
        return new ResponseEntity<Pabellon>(pab,HttpStatus.CREATED);
    }

    @PutMapping("/liberar")
    public Pabellon liberar (@RequestParam(name = "id") long id ){
        Optional <Pabellon> pabellon3 = pab_service.obtenerporId(id);
        if(pabellon3.isPresent() == true){
            Pabellon pabellon4 = pabellon3.get();
            pabellon4.setEstado("Disponible");
            pabellon4.setId_paciente(0);
            return pab_service.SaveOrUpdatePabellon(pabellon4);
        }
        else{
            return null;
        }
    }
}