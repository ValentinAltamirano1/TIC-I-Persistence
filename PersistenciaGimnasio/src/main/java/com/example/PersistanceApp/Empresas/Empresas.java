package com.example.PersistanceApp.Empresas;

import com.example.PersistanceApp.Empleados.Empleados;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Empresas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_empresa")
    private int id_empresa;


    @OneToMany
    @JoinColumn(name = "id_empresa")
    private Set<Empleados> empleados;
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
