package com.example.PersistanceApp.Empleados;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empresas.Empresas;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Empleados {


   /* @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "actividades_empleados",
                joinColumns= @JoinColumn(name="pasaporte"),
            inverseJoinColumns = @JoinColumn(name = "id_actividad"))
    private List<Actividades> actividades=new ArrayList<>();*/

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

    @ManyToOne
    @JoinColumn(name = "empresas_rut")
    private Empresas empresas;

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

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

