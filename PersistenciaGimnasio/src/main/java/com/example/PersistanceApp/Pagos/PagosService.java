package com.example.PersistanceApp.Pagos;

import com.example.PersistanceApp.Empresas.Empresas;
import com.example.PersistanceApp.Reservas.Reservas;
import com.example.PersistanceApp.Reservas.ReservasRepository;
import com.example.PersistanceApp.Usuario.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagosService {
    private PagosRepository pagosRepository;

    private ReservasRepository reservasRepository;

    @Autowired
    public PagosService(PagosRepository pagosRepository) {
        this.pagosRepository = pagosRepository;
    }
    public List<Pagos> getPagos(){return pagosRepository.findAll(); //devuelve lista
    }
    public void addNewPago() {
        List<Reservas> reservas = reservasRepository.findReservaByMail();
        for (int i=0;i<reservas.size();i++){
            if(pagosRepository.findCentroByRut(reservas.get(i).getActividades().getActividadesKey().getCentrosDeportivos().getRut(), reservas.get(i).getReservasKey().getEmpleados().getEmpresas().getRut()).isPresent()){
                //seteo el valor
                Pagos pago = pagosRepository.findCentroByRut(reservas.get(i).getActividades().getActividadesKey().getCentrosDeportivos().getRut(), reservas.get(i).getReservasKey().getEmpleados().getEmpresas().getRut()).get();
                pago.setGasto(pago.getGasto() + reservas.get(i).getActividades().getPrecio());
            }
            PagosKey pagosKey = new PagosKey(reservas.get(i).getReservasKey().getEmpleados().getEmpresas(),reservas.get(i).getActividades().getActividadesKey().getCentrosDeportivos());
            Pagos pagos1 = new Pagos(reservas.get(i).getActividades().getPrecio(),pagosKey);
            pagosRepository.save(pagos1);
        }
    }
}
