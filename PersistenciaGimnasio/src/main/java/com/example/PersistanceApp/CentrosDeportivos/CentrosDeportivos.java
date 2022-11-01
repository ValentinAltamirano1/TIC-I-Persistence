package com.example.PersistanceApp.CentrosDeportivos;

import com.example.PersistanceApp.Actividades.Actividades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity (name="CentrosDeportivos")
@Table
public class CentrosDeportivos {

    @Id
    @Column(name = "rut", nullable = false)
    private Long rut;
    @Column(name = "telefono", nullable = false , unique = true)
    private Long telefono;
    @Column(name = "nombre", nullable = false , columnDefinition = "TEXT")
    private String nombre;
    @Column(name = "direccion", nullable = false , columnDefinition = "TEXT" , unique = true)
    private String direccion;

    @Column(name = "mail", nullable = false , unique = true)
    private String mail;

    @Column(name = "contra", nullable = false)
    private String contra;

    @Column(name = "tipo", nullable = false)
    private String tipo;


    public CentrosDeportivos(Long rut, Long telefono, String nombre, String direccion, String mail, String contra, String tipo) {
        this.rut = rut;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = mail;
        this.contra = contra;
        this.tipo = tipo;
    }

    public CentrosDeportivos() {

    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

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
        return "CentrosDeportivos{" +
                "rut=" + rut +
                ", telefono=" + telefono +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", mail='" + mail + '\'' +
                ", contra='" + contra + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
