package com.example.PersistanceApp.Imagen;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.awt.*;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImagenService {


    private ImageRepository imageRepository;

    @Autowired
    public ImagenService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Imagenes uploadImage(MultipartFile file) throws IOException {
        Imagenes pImage = new Imagenes(file.getName());
        return imageRepository.save(pImage); //tengo que ver si es null?
    }

    public String downloadImage(String fileName) {
        Optional<Imagenes> imageData = imageRepository.findByNombre(fileName);
        return imageData.get().getNombre();
    }
}

    /*
    @Transactional
    public Imagenes getInfoByImageByName(String nombre ){
        Optional<Imagenes> dbImagen= imageRepository.findByNombre(nombre);
        Imagenes imagenes= new Imagenes(dbImagen.get().getNombre(), dbImagen.get().getTipo(),dbImagen.get().getImageData());
        return imagenes;
        //return Imagenes.builder().nombre(dbImagen.get().getNombre()).
               // tipo(dbImagen.get().getTipo()).imageData(ImageUtility.decompressImage(dbImagen.get().getImageData())).build();
    }
}
 */