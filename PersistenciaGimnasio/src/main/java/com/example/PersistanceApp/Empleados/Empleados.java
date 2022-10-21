package com.example.PersistanceApp.Empleados;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empresas.Empresas;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_empleado")
    private int id_empleado;
    @Column(name = "pasaporte")
    private String pasaporte;

    @ManyToMany(mappedBy = "empleados")
    private Set<Actividades>actividades;


    @ManyToOne
    @JoinColumn(name = "id_empresa", insertable = false,updatable = false)
    Empresas empresas; // muchos empleados pueden pertenecer a una misma empresa

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "mail")
    private String mail;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "fichaMedica")
    private LocalDate fichaMedica;
    @Column(name = "tipo")
    private String tipo;

    public Empleados() {
    }

    public Empleados(String pasaporte, String nombre, int telefono, String mail, String contraseña, LocalDate fichaMedica, String tipo) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.contraseña = contraseña;
        this.fichaMedica = fichaMedica;
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

    public LocalDate getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(LocalDate fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", mail='" + mail + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", fichaMedica=" + fichaMedica +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
