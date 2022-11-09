/*package com.example.PersistanceApp.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    private HorarioRepository horarioRepository;

    @Autowired
    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public List<Horario> getHorarioKey(){return horarioRepository.findAll(); //devuelve lista
        }

    public void addNewHorario(Horario horario) {
        Optional<Horario> horarioByKey = horarioRepository.findHorarioByHorarioKey(horario.getHorarioKey().getDia_de_semana(),horario.getHorarioKey().getHorario_inicio(),horario.getHorarioKey().getHorario_fin());
        if(horarioByKey.isPresent()){
            try {
                throw new IllegalAccessException("Horario ingresado");
            } catch (IllegalAccessException e) {

            }
        }
        horarioRepository.save(horario);
    }
}*/
