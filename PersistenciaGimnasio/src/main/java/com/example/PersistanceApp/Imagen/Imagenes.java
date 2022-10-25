package com.example.PersistanceApp.Imagen;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String tipo;

    @Lob
    @Column(name = "imagedata", unique = false, nullable = false,length = 1000)
    private byte[] imageData;


}
