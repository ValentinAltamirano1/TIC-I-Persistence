package com.example.PersistanceApp.Actividades;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable
public class ActividadesKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "centros_deportivos_rut")
    private CentrosDeportivos centrosDeportivos;

    @Column(name = "nombre", updatable = false)
    private String nombre;

    public ActividadesKey() {
    }

    public ActividadesKey(CentrosDeportivos centrosDeportivos, String nombre) {
        this.centrosDeportivos = centrosDeportivos;
        this.nombre = nombre;

    }

    public CentrosDeportivos getCentrosDeportivos() {
        return centrosDeportivos;
    }

    public void setCentrosDeportivos(CentrosDeportivos centrosDeportivos) {
        this.centrosDeportivos = centrosDeportivos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "ActividadesKey{" +
                "centrosDeportivos=" + centrosDeportivos +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
