package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservasService {
    private final ReservasRepository reservasRepository;

    @Autowired
    public ReservasService(ReservasRepository reservasRepository) {this.reservasRepository = reservasRepository;}

    public List<Reservas> getReservas(){return reservasRepository.findAll(); //devuelve lista
    }

    @Transactional
    public List<Actividades> getActividadesUsuario(String pasaporte){return reservasRepository.findActivitiesByPassport(pasaporte);}

    @Transactional
    public List<Actividades> getActividadesCentro(Long rut){return reservasRepository.findActivitiesByRut(rut);}
    @Transactional
    public List<Reservas> getReservasMail(String mail){return reservasRepository.findReservasByMail(mail);}

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

    /*
    public void deleteReserva(ReservasKey reservasKey){
        boolean existe=reservasRepository.existsById(reservasKey);
        if (!existe){
            throw new IllegalStateException("reservas con key"+ reservasKey + "no existe");
        }
        reservasRepository.deleteById(reservasKey);
    }*/
}
