package com.example.PersistanceApp.Empleados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Empleados {
    /*@ManyToMany(mappedBy = "empleados")
    private Set<Actividades>actividades;


    @ManyToOne
    @JoinColumn(name = "id_empresa", insertable = false,updatable = false)
    Empresas empresas; // muchos empleados pueden pertenecer a una misma empresa*/

    @Id
    @Column(name = "pasaporte")
    private String pasaporte;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "mail")
    private String mail;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "ficha_medica")
    private String ficha_medica;
    @Column(name = "tipo")
    private String tipo;

    public Empleados() {
    }

    public Empleados(String pasaporte, String nombre, int telefono, String mail, String contraseña, String fichaMedica, String tipo) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.contraseña = contraseña;
        this.ficha_medica = fichaMedica;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFicha_medica() {
        return ficha_medica;
    }

    public void setFicha_medica(String ficha_medica) {
        this.ficha_medica = ficha_medica;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", mail='" + mail + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", ficha_medica=" + ficha_medica +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

