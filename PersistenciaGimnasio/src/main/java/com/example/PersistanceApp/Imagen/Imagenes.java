package com.example.PersistanceApp.Imagen;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empresas.Empresas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
/*
@Entity
@Table(name = "imagenes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Imagenes {

    @ManyToOne
    @JoinColumn(name = "actividades_id_actividad")
    private Actividades actividades;


    @Lob
    @Column(name = "imagedata",length = 100000)
    private byte[] imageData;

    @Id
    @Column(name = "nombre")
    private String nombre;

    public Actividades getActividades() {
        return actividades;
    }

    public Imagenes(byte[] imageData, String nombre) {
        this.imageData = imageData;
        this.nombre = nombre;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    public Imagenes(byte[] imageData) {
        this.imageData = imageData;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Imagenes{" +
                "imageData=" + Arrays.toString(imageData) +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
 */