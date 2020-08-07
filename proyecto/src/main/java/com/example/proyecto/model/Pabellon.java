package com.example.proyecto.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pabellon{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id = 0;

    private String estado = null;
    private long paciente = 0;
    public int capacidad = 5;
    public int disponible = 5;
    
    public void pabellon(long id, String estado, long paciente, int capacidad,int disponible) {
        this.id = id;
        this.estado = estado;
        this.paciente = paciente;
        this.capacidad = capacidad;
        this.disponible = disponible;
    }

    public long getId(){
        return id;
    }
    
    public void setId(long Id){
        this.id = Id;
    }

    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }

    public long getpaciente(){
        return paciente;
    }
    
    public void setpaciente(long paciente){
        this.paciente = paciente;
    }

}