package com.example.PersistanceApp.Empleados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Empleados {
    @Id
    @Column(name = "pasaporte")
    private String pasaporte;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "mail")
    private String mail;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "tipo")
    private String tipo;

    public Empleados() {
    }

    public Empleados(String pasaporte, String nombre, String mail, int telefono, String tipo) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono=" + telefono +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
