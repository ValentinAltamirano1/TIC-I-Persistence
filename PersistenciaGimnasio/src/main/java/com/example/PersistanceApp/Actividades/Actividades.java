package com.example.PersistanceApp.Actividades;


import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.Imagen.Imagenes;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "Actividades")
@Table()
public class Actividades {
    @EmbeddedId
    private ActividadesKey actividadesKey;
    @Column(name = "precio" ,nullable = false)
    private int precio;
    @Column(name = "categoria" ,nullable = false )
    private String categoria;
    @Column(name = "capacidad" , nullable = false)
    private int capacidad;

    @Column(name = "descripcion" , nullable = false)
    private String descripcion;

    @Column(name = "cupos" , nullable = false)
    private int cupos;


    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "imagen", nullable = false)
    private List<Imagenes> imagen;


    public Actividades() {
    }

    public Actividades(ActividadesKey actividadesKey, int precio, String categoria, int capacidad, String descripcion, int cupos) {
        this.actividadesKey = actividadesKey;
        this.precio = precio;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.cupos = cupos;
    }

    public Actividades(ActividadesKey actividadesKey, int precio, String categoria, int capacidad, String descripcion, int cupos, List<Imagenes> imagen) {
        this.actividadesKey = actividadesKey;
        this.precio = precio;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.cupos = cupos;
        this.imagen = imagen;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public List<Imagenes> getImagen() {
        return imagen;
    }

    public void setImagen(List<Imagenes> imagen) {
        this.imagen = imagen;
    }

    public ActividadesKey getActividadesKey() {
        return actividadesKey;
    }

    public void setActividadesKey(ActividadesKey actividadesKey) {
        this.actividadesKey = actividadesKey;
    }

    @Override
    public String toString() {
        return "Actividades{" +
                "actividadesKey=" + actividadesKey +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", capacidad=" + capacidad +
                ", descripcion='" + descripcion + '\'' +
                ", cupos=" + cupos +
                ", imagen=" + imagen +
                '}';
    }
}
