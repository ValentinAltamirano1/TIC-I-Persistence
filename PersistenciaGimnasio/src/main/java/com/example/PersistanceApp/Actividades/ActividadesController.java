package com.example.PersistanceApp.Actividades;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/gimnasio/actividades")
public class ActividadesController {
    private final ActividadesService actividadesService;

    @Autowired
    public ActividadesController(ActividadesService actividadesService){
        this.actividadesService = actividadesService;
    }

    @GetMapping
    public List<Actividades> getActividades(){
        return actividadesService.getActividades();
    }

    @GetMapping("/{categoria}")
    public List<Actividades> getActividadesCancha(@PathVariable("categoria") String categoria){
        return actividadesService.getActividadesCateg(categoria);
    }

    @GetMapping("/{mail}")
    public List<Actividades> getActividadesCentroMail(@PathVariable("mail") String mail){
        return actividadesService.getActividadesCentro(mail);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevaActividad(@RequestBody Actividades actividades){
        actividadesService.addNewActividades(actividades);
    }
}
