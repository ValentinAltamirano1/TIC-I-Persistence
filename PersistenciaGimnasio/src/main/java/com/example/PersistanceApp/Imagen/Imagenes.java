package com.example.PersistanceApp.Imagen;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empresas.Empresas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "imagenes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Imagenes {


    @ManyToOne
    @JoinColumn(name = "id_actividad",updatable = true)
    Actividades actividades; // muchos empleados pueden pertenecer a una misma empresa

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String tipo;

    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;

    public Imagenes(String nombre, String tipo, byte[] imageData) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.imageData = imageData;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

}
