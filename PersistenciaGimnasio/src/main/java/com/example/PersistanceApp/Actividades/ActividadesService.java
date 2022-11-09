package com.example.PersistanceApp.Actividades;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadesService {
    private final ActividadesRepository actividadesRepository;

    @Autowired
    public ActividadesService(ActividadesRepository actividadesRepository) {
        this.actividadesRepository = actividadesRepository;
    }

    public List<Actividades> getActividadesCentro(String mail){return actividadesRepository.findActividadesByCentro(mail);}
    public List<Actividades> getActividades(){return actividadesRepository.findAll(); //devuelve lista
    }

    public List<Actividades> getActividadesCateg(String categoria){return actividadesRepository.findActivitiesByCategorise(categoria);}

    public void addNewActividades(Actividades actividades) {
        /*Optional<Actividades> actividadesByKey = actividadesRepository.findActivitiesByKey(actividades.getActividadesKey());
        if(actividadesByKey.isPresent()){
            try {
                throw new IllegalAccessException("Actividad ya ingresada");
            } catch (IllegalAccessException e) {

            }
        }*/
        actividadesRepository.save(actividades);
    }

}
