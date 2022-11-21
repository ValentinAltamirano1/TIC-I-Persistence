package com.example.PersistanceApp.Actividades;


import com.example.PersistanceApp.Horario.HorarioKey;
import org.hibernate.type.LocalTimeType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
public class ActividadesService {


    private final ActividadesRepository actividadesRepository;

    @Autowired
    public ActividadesService(ActividadesRepository actividadesRepository) {
        this.actividadesRepository = actividadesRepository;
    }
    @Transactional
    public List<HorarioKey> getActividadesHorario(String dia_semana, String nombre, Long rut){
        return actividadesRepository.findActivitiesByDiaSemanaNombreRut(dia_semana, nombre, rut);
    }

    @Transactional
    public List<Actividades> getActividadesCentro(String mail){return actividadesRepository.findActividadesByCentro(mail);}
    @Transactional
    public List<Actividades> getActividades(){return actividadesRepository.findAll(); //devuelve lista
    }
    @Transactional
    public List<Actividades> getActividadesCateg(String categoria){return actividadesRepository.findActivitiesByCategorise(categoria);}

    @Transactional
    public List<Actividades> getActividadesNombre(String nombre){return actividadesRepository.findActividadesByNombre(nombre);}
    @Transactional
    public List<Actividades> getActividadMailNombre(String mail, String nombre){return actividadesRepository.findActividadesByKey(mail,nombre);}
    @Transactional
    public List<Actividades> getActividadesCupos(){return actividadesRepository.findActivities();}
    @Transactional
    public void addNewActividades(Actividades actividades) {
        String horario_inicio= actividades.getHorarios().get(0).getHorario_inicio();
        System.out.println(horario_inicio);
        String horario_fin= actividades.getHorarios().get(0).getHorario_fin();
        LocalTime date_inicio= LocalTime.parse(horario_inicio);
        LocalTime date_fin= LocalTime.parse(horario_fin);
        System.out.println(date_inicio);
        Optional<Actividades> actividadesByKey=actividadesRepository.findActividadesByActividadesKey(actividades.getActividadesKey());

        if (actividadesByKey.isPresent()){

            List<HorarioKey> actividadesByDay = actividadesRepository.findActivitiesByHorarios(actividades.getActividadesKey().getCentrosDeportivos().getRut(), actividades.getActividadesKey().getNombre(),actividades.getCapacidad(),actividades.getCupos(), actividades.getCategoria(), actividades.getDescripcion(),actividades.getPrecio());
            for (int i =0; i<actividadesByDay.size(); i++){

                if (actividadesByDay.get(i).getDia_de_semana().equals(actividades.getHorarios().get(0).getDia_de_semana())){ //ver que tengan mismo dia de semana
                    String horario_i=actividadesByDay.get(i).getHorario_inicio();
                    String horario_f=actividadesByDay.get(i).getHorario_fin();
                    LocalTime date_i= LocalTime.parse(horario_i);
                    LocalTime date_f= LocalTime.parse(horario_f);
                    if ((date_inicio.isAfter(date_i)&& date_fin.isBefore(date_f)) ||(date_inicio.isBefore(date_i) && date_fin.isAfter(date_f))){
                        return;}

                    if ((horario_inicio.equals(horario_i) || date_fin.equals(horario_fin))){
                        return;
                    }
                }
                }
            actividadesByKey.get().getHorarios().add(actividades.getHorarios().get(0));

        }
        else{
            actividadesRepository.save(actividades);}
    }

    @Transactional
    public void updateActividad(Actividades actividades){
        actividadesRepository.updateActividadExistente(actividades.getActividadesKey());
    }

    public ActividadesRepository getActividadesRepository() {
        return actividadesRepository;
    }

    public void deleteActividad(ActividadesKey actividadesKey){ //ver si sirve pasarlo a string???
        boolean existe=actividadesRepository.existsById(String.valueOf(actividadesKey));
        if (!existe){
            throw new IllegalStateException("Actividad con key"+ actividadesKey + "no existe");
        }
        actividadesRepository.deleteById(String.valueOf(actividadesKey));
    }


}
