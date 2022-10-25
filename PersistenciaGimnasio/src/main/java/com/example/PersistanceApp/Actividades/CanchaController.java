package com.example.PersistanceApp.Actividades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/gimnasio/cancha")
public class CanchaController {
    private final ActividadesService actividadesService;

    @Autowired
    public CanchaController(ActividadesService actividadesService){
        this.actividadesService = actividadesService;
    }

    @GetMapping
    public List<Actividades> getActividadesCancha(Actividades actividades){
        System.out.println(actividadesService.getActividadesCateg(actividades));
        return actividadesService.getActividadesCateg(actividades);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevaActividad(@RequestBody Actividades actividades){
        actividadesService.addNewActividades(actividades);
    }
}