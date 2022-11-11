package com.example.PersistanceApp.CentrosDeportivos;

import com.example.PersistanceApp.Empresas.Empresas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/gimnasio/centroDeportivo")
public class CentrosDeportivosController {

    private final CentrosDeportivosService centrosDeportivosService;

    @Autowired
    public CentrosDeportivosController(CentrosDeportivosService centrosDeportivosService){
        this.centrosDeportivosService = centrosDeportivosService;
    }
    @GetMapping("/{mail}")
    public List<CentrosDeportivos> getCentroDeportivo(@PathVariable("mail") String mail){
        System.out.println(mail);
        return centrosDeportivosService.getCentroDeportivo(mail);
    }

    @GetMapping
    public List<CentrosDeportivos> getCentroDeportivo(){
        return centrosDeportivosService.getCentroDeportivo();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevoCentroDeportivo(@RequestBody CentrosDeportivos centrosDeportivos){
        centrosDeportivosService.addNewCentroDeportivo(centrosDeportivos);
    }
    @DeleteMapping(path = "{rut}")
    public void deleteCentroDeportivos(@PathVariable("rut") Long rut){
        centrosDeportivosService.deleteCentroDeportivo(rut);
    }

}
