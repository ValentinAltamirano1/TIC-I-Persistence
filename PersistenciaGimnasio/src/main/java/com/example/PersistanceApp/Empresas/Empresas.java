package com.example.PersistanceApp.Empresas;

import com.example.PersistanceApp.Empleados.Empleados;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Empresas {

    @Id
    @Column(name = "rut", updatable = false)
    private Long rut;
    @Column(name = "nombre", nullable = false , columnDefinition = "TEXT")
    private String nombre;

    @Column(name = "mail", nullable = false , unique = true)
    private String mail;

    @Column(name = "contra", nullable = false)
    private String contra;

    @Column(name = "tipo", nullable = false)
    private String tipo;


    public Empresas() {
    }

    public Empresas(Long rut, String nombre, String mail, String contra, String tipo) {
        this.rut = rut;
        this.nombre = nombre;
        this.mail = mail;
        this.contra = contra;
        this.tipo = tipo;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Long getRut() {return rut;}

    public void setRut(Long rut) {this.rut = rut;}

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Empresas{" +
                "rut=" + rut +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", contra='" + contra + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

