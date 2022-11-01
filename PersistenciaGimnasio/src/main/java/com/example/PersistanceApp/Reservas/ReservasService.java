package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservasService {
    private final ReservasRepository reservasRepository;

    @Autowired
    public ReservasService(ReservasRepository reservasRepository) {this.reservasRepository = reservasRepository;}

    public List<Reservas> getReservas(){return reservasRepository.findAll(); //devuelve lista
    }

    public List<Actividades> getActividadesUsuario(String pasaporte){return reservasRepository.findActivitiesByPassport(pasaporte);}

    public void addNewReserva(Reservas reserva) {
        /*Optional<Actividades> actividadesByKey = actividadesRepository.findActividadesByKey(actividades.getActividadesKey());
        if(actividadesByKey.isPresent()){
            try {
                throw new IllegalAccessException("Actividad ya ingresada");
            } catch (IllegalAccessException e) {

            }
        }*/
        reservasRepository.save(reserva);
    }
}
