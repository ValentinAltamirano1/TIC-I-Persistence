package com.example.PersistanceApp.Empresas;

import javax.persistence.*;

@Entity
@Table
public class Empresas {
    @Id
    @Column(name = "rut", updatable = false)
    private Long rut;
    @Column(name = "nombre", nullable = false , columnDefinition = "TEXT")
    private String nombre;

    public Empresas() {
    }

    public Empresas(String nombre, Long rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Long getRut() {return rut;}

    public void setRut(Long rut) {this.rut = rut;}

    @Override
    public String toString() {
        return "Empresa{" +
                "rut=" + rut +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
