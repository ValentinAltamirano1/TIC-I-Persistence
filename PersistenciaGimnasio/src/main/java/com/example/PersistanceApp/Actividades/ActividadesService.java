package com.example.PersistanceApp.Actividades;


import com.example.PersistanceApp.Horario.HorarioKey;
import org.hibernate.type.LocalTimeType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ActividadesService {


    private final ActividadesRepository actividadesRepository;

    @Autowired
    public ActividadesService(ActividadesRepository actividadesRepository) {
        this.actividadesRepository = actividadesRepository;
    }

    public List<Actividades> getActividadesCentro(String mail){return actividadesRepository.findActividadesByCentro(mail);}
    @Transactional
    public List<Actividades> getActividades(){return actividadesRepository.findAll(); //devuelve lista
    }
    @Transactional
    public List<Actividades> getActividadesCateg(String categoria){return actividadesRepository.findActivitiesByCategorise(categoria);}

    @Transactional
    public void addNewActividades(Actividades actividades) {
        String horario_inicio= actividades.getHorarios().get(0).getHorario_inicio();
        System.out.println(horario_inicio);
        String horario_fin= actividades.getHorarios().get(0).getHorario_fin();
        //String[] time_i = horario_inicio.split ( ":" );
        //int hour_i = Integer.parseInt ( time_i[0].trim() );
        //int min_i = Integer.parseInt ( time_i[1].trim() );
        LocalTime date_inicio= LocalTime.parse(horario_inicio);
        LocalTime date_fin= LocalTime.parse(horario_fin);
        System.out.println(date_inicio);
        Optional<Actividades> actividadesByKey=actividadesRepository.findActividadesByActividadesKey(actividades.getActividadesKey());

        if (actividadesByKey.isPresent()){

            List<HorarioKey> actividadesByDay = actividadesRepository.findActivitiesByHorarios(actividades.getActividadesKey().getCentrosDeportivos().getRut(), actividades.getActividadesKey().getNombre());
            for (int i =0; i<actividadesByDay.size(); i++){

                if (actividadesByDay.get(i).getDia_de_semana().equals(actividades.getHorarios().get(0).getDia_de_semana())){
                    String horario_i=actividadesByDay.get(i).getHorario_inicio();
                    String horario_f=actividadesByDay.get(i).getHorario_fin();
                    LocalTime date_i= LocalTime.parse(horario_i);
                    LocalTime date_f= LocalTime.parse(horario_f);

                    if (!(date_inicio.isAfter(date_i) && date_inicio.isBefore(date_f)) || !(date_fin.isAfter(date_i) && date_fin.isBefore(date_f))) {
                        if (date_inicio.equals(horario_inicio) || date_fin.equals(horario_fin)){
                            try {
                                throw new IllegalAccessException("Actividad ya ingresada");
                                }
                            catch (IllegalAccessException e) {}}}
                    else{
                        try {
                            throw new IllegalAccessException("Actividad ya ingresada");
                            }
                        catch (IllegalAccessException e) {}
                    }
                }
            }
            actividadesByKey.get().getHorarios().add(actividades.getHorarios().get(0));
        }else{
            actividadesRepository.save(actividades);}
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
