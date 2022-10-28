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
    @JoinColumn(name = "actividades_id_actividad")
    private Actividades actividades;

    @Id
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;

    public Actividades getActividades() {
        return actividades;
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

}
