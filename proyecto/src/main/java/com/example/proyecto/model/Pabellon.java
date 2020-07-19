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
    private long id_paciente = 0;
    
    public void pabellon(long id, String estado, long id_paciente) {
        this.id = id;
        this.estado = estado;
        this.id_paciente = id_paciente;
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

    public long getId_paciente(){
        return id_paciente;
    }
    
    public void setId_paciente(long Id_paciente){
        this.id_paciente = Id_paciente;
    }

}