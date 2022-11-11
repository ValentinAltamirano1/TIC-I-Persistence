package com.example.PersistanceApp.Actividades;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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

    public void deleteActividad(ActividadesKey actividadesKey){ //ver si sirve pasarlo a string???
        boolean existe=actividadesRepository.existsById(String.valueOf(actividadesKey));
        if (!existe){
            throw new IllegalStateException("Actividad con key"+ actividadesKey + "no existe");
        }
        actividadesRepository.deleteById(String.valueOf(actividadesKey));



    }

}
