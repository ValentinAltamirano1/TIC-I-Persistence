package com.example.PersistanceApp.Actividades;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "Actividades")
@Table
public class Actividades {
    @Id
    @SequenceGenerator(
            name="actividades_sequence",
            sequenceName="actividades_sequence",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "activiades_sequence"
    )

    @Column(name = "nombre", updatable = false)
    private String nombre;
    @Column(name = "horario",nullable = false )
    private Date horario;
    @Column(name = "precio" ,nullable = false)
    private int precio;

    @Column(name = "categoria" ,nullable = false )
    private String categoria;
    @Column(name = "capacidad" , nullable = false)
    private int capacidad;



    public Actividades() {
    }

    public Actividades(String nombre, Date horario, int precio, String categoria, int capacidad) {
        this.nombre = nombre;
        this.horario = horario;
        this.precio = precio;
        this.categoria = categoria;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Actividades{" +
                "nombre='" + nombre + '\'' +
                ", horario=" + horario +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
