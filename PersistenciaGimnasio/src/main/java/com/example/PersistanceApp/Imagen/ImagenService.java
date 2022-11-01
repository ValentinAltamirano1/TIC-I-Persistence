package com.example.PersistanceApp.Imagen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.awt.*;
import java.io.IOException;
import java.util.Optional;
/*
@Service
public class ImagenService {


    private ImageRepository imageRepository;
    @Autowired
    public ImagenService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile file)throws IOException{
        Imagenes imagenes= new Imagenes(file.getOriginalFilename(), file.getContentType(), file.getBytes() );
        imageRepository.save(imagenes);
        //imageRepository.save(Imagenes.builder().nombre(file.getOriginalFilename()).tipo(file.getContentType()).
        //imageData(ImageUtility.compressImage(file.getBytes())).build());
        if(imagenes!=null){
            return ("Imagen subida de forma exitosa:" + file.getOriginalFilename());//hacer constructor
        }
       return null;
    }
    public Imagenes uploadImage(MultipartFile file)throws IOException{
        Imagenes pImage= new Imagenes(file.getBytes());
        return imageRepository.save(pImage);
    }

    public byte [] downloadImage(byte fileName){
        Optional<Imagenes> imageData=imageRepository.findByImageData(fileName);
        return ImageUtility.decompressImage(imageData.get().getImageData());
    }

    @Transactional
    public Imagenes getInfoByImageByName(String nombre ){
        Optional<Imagenes> dbImagen= imageRepository.findByNombre(nombre);
        Imagenes imagenes= new Imagenes(dbImagen.get().getNombre(), dbImagen.get().getTipo(),dbImagen.get().getImageData());
        return imagenes;
        //return Imagenes.builder().nombre(dbImagen.get().getNombre()).
               // tipo(dbImagen.get().getTipo()).imageData(ImageUtility.decompressImage(dbImagen.get().getImageData())).build();
    }

   @Transactional
    public byte[] getImage(String nombre){
        Optional<Imagenes> dbImagen= imageRepository.findByNombre(nombre);
        byte[] image= ImageUtility.decompressImage(dbImagen.get().getImageData());

        return image;
    }
}
 */