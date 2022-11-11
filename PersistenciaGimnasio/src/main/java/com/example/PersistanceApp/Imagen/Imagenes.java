package com.example.PersistanceApp.Imagen;


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
