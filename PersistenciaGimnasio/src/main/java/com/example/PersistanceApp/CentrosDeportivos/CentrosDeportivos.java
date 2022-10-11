package com.example.PersistanceApp.CentrosDeportivos;

import javax.persistence.*;

@Entity (name="CentrosDeportivos")
@Table
public class CentrosDeportivos {
    @Id
    @SequenceGenerator(
            name="centrosDeportivos_sequence",
            sequenceName="centrosDeportivos_sequence",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "centrosDeportivos_sequence"
    )

    @Column(name = "rut", updatable = false)
    private Long rut;
    @Column(name = "telefono", nullable = false , unique = true)
    private Long telefono;
    @Column(name = "nombre", nullable = false , columnDefinition = "TEXT")
    private String nombre;
    @Column(name = "direccion", nullable = false , columnDefinition = "TEXT" , unique = true)
    private String direccion;


    public CentrosDeportivos(Long telefono, String nombre, String direccion, Long rut) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.rut = rut;
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

    @Override
    public String toString() {
        return "CentrosDeportivos{" +
                "rut=" + rut +
                ", telefono=" + telefono +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
