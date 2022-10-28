package com.example.PersistanceApp.Actividades;


import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.Empleados.Empleados;
import com.example.PersistanceApp.Imagen.Imagenes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity(name = "Actividades")
@Table
public class Actividades {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_actividad")
    private int id_actividad;

   /* @ManyToMany(mappedBy = "actividades")
    private List<Empleados> empleados=new ArrayList<>() ;

    /*@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "actividades_empleados_mapping")
    @JoinColumn(name = "id_actividad")
    @JoinColumn(name = "id_empleado")
    private Set<Empleados> empleados;*/


    @ManyToOne
    @JoinColumn(name = "rut", insertable = false,updatable = false)
    CentrosDeportivos centrosDeportivos; // muchos actividades pueden pertenecer a un mismo centro deportivo

    @OneToMany
    @JoinColumn(name = "id_actividad")
    private Set<Imagenes> imagenes;


    @Column(name = "nombre", updatable = false)
    private String nombre;
    @Column(name = "horario",nullable = false )
    private String horario;
    @Column(name = "precio" ,nullable = false)
    private int precio;
    @Column(name = "categoria" ,nullable = false )
    private String categoria;
    @Column(name = "capacidad" , nullable = false)
    private int capacidad;



    public Actividades() {
    }

    public Actividades(String nombre, String horario, int precio, String categoria, int capacidad) {
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

    public String getHorario() {return horario;
    }

    public void setHorario(String horario) {this.horario = horario;
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

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
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
