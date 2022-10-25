package com.example.PersistanceApp.Imagen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImagenService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageUploadResponse uploadImage(MultipartFile file)throws IOException{
        imageRepository.save(Imagenes.builder().nombre(file.getOriginalFilename()).tipo(file.getContentType()).
                imageData(ImageUtility.compressImage(file.getBytes())).build());
        return new ImageUploadResponse("Imagen subida de forma exitosa:" + file.getOriginalFilename());
    }

    @Transactional
    public Imagenes getInfoByIdImagen(Long id){
        Optional<Imagenes> dbImagen= imageRepository.findById(id);

        return Imagenes.builder().nombre(dbImagen.get().getNombre()).
                tipo(dbImagen.get().getTipo()).imageData(ImageUtility.decompressImage(dbImagen.get().getImageData())).build();
    }

    @Transactional
    public byte[] getImage(Long id){
        Optional<Imagenes> dbImagen= imageRepository.findById(id);
        byte[] image= ImageUtility.decompressImage(dbImagen.get().getImageData());

        return image;
    }
}
