package com.example.PersistanceApp.Imagen;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empresas.Empresas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;



@Embeddable
public class Imagenes implements Serializable {

    @Lob
    @Column(name = "nombre")
    private String nombre;

    public Imagenes() {

    }

    public Imagenes(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Imagenes{" +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
