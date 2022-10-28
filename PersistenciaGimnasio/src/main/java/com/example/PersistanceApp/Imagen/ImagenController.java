package com.example.PersistanceApp.Imagen;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path="api/v1/gimnasio/imagen")
public class ImagenController {


    private final ImagenService imagenService;
    @Autowired
    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadimage (@RequestParam ("imagen")MultipartFile file) throws IOException{
        String response=imagenService.uploadImage(file);

        return  ResponseEntity.status(HttpStatus.OK).body(response);

    }


    @PostMapping("/uploadMultipleImages")
    public ResponseEntity uploadMultipleFiles(@RequestParam ("imagen")MultipartFile[] files){
        /*try {
            return Arrays.asList(files).stream().map(file -> uploadimage(file)).collect(Collectors.toList());
        }catch (IOException e){}*/

        for(MultipartFile file : files) {
            try {
                imagenService.uploadImage(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return  ResponseEntity.status(HttpStatus.OK).body("");
    }


    @GetMapping("/info/{nombre}")
    public ResponseEntity<?> getImageInfoByNombre(@PathVariable("nombre") String nombre){
        Imagenes imagenes= imagenService.getInfoByImageByName(nombre);

        return ResponseEntity.status(HttpStatus.OK).body(imagenes);
    }
    @GetMapping("/{nombre}")
    public  ResponseEntity<?> getImageByNombre(@PathVariable("nombre") String nombre){
        byte[] imagen= imagenService.getImage(nombre);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("imagen/png"))
                .body(imagen);
    }


}
