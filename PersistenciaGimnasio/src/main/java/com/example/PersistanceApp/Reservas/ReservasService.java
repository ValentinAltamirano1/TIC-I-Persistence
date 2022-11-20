package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
    public List<Reservas> getReservasMail(String mail){
        List<Reservas> reservas=reservasRepository.findReservasByMail(mail);
        for(int i=0;i< reservas.size();i++){
            String fecha=reservas.get(i).getReservasKey().getFecha();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaR = LocalDate.parse(fecha, formatter);
            if (!fechaR.isEqual(java.time.LocalDate.now())){
                reservas.remove(i);
            }
        }
        return reservas;}

    public void addNewReserva(Reservas reserva) {
        Optional<Reservas> reservasByKey = reservasRepository.findReservasByKey(reserva.getReservasKey());
        if(reservasByKey.isPresent()){
            try {
                throw new IllegalAccessException("Actividad ya ingresada");
            } catch (IllegalAccessException e) {

            }
        }
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
