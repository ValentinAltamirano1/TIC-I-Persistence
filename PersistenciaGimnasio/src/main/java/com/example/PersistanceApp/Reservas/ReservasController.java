package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empresas.Empresas;
import com.example.PersistanceApp.Usuario.Usuarios;
import com.example.PersistanceApp.Usuario.UsuariosService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/gimnasio/reservas")
public class ReservasController {

    private final ReservasService reservasService;

    @Autowired
    public ReservasController(ReservasService reservasService){this.reservasService = reservasService;}

    @GetMapping
    public List<Reservas> getReservas(){return reservasService.getReservas();}

    @GetMapping("/{pasaporte}")
    public List<Actividades> getActividadesUsuario(@PathVariable("pasaporte") String pasaporte){
        return reservasService.getActividadesUsuario(pasaporte);
    }

    @GetMapping("/getRut/{rut}")
    public List<Actividades> getActividadesCentro(@PathVariable("rut") Long rut){
        return reservasService.getActividadesCentro(rut);
    }

    @GetMapping("/getMail/{mail}")
    public List<Reservas> getReservasCentros(@PathVariable("mail") String mail){
        return reservasService.getReservasMail(mail);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevaReserva(@RequestBody Reservas reserva){
        reservasService.addNewReserva(reserva);
    }
    @PostMapping(path = "/update",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void updateReservas(@RequestBody Reservas reservas){
        reservasService.updateReserva(reservas);
    }

   /* @DeleteMapping(path = "{reservasKey}")
    public void deleteReservas(@PathVariable("reservasKey") ReservasKey reservasKey){
        reservasService.deleteReserva(reservasKey);
    }*/
}
