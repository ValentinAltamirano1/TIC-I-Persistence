package com.example.PersistanceApp.Pagos;

import com.example.PersistanceApp.Empresas.Empresas;
import com.example.PersistanceApp.Reservas.Reservas;
import com.example.PersistanceApp.Reservas.ReservasRepository;
import com.example.PersistanceApp.Usuario.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PagosService {
    private PagosRepository pagosRepository;

    private ReservasRepository reservasRepository;

    @Autowired
    public PagosService(PagosRepository pagosRepository, ReservasRepository reservasRepository) {
        this.pagosRepository = pagosRepository;
        this.reservasRepository = reservasRepository;
    }
    public List<Pagos> getPagos(){return pagosRepository.findAll(); //devuelve lista
    }

    @Transactional
    public void addNewPago() {
        List<Reservas> reservas = reservasRepository.findReservaByMail();
        for (int i=0;i<reservas.size();i++){
            if(pagosRepository.findCentroByRut(reservas.get(i).getActividades().getActividadesKey().getCentrosDeportivos().getRut(), reservas.get(i).getReservasKey().getEmpleados().getEmpresas().getRut()).isPresent()){
                //seteo el valor
                if(reservas.get(i).getEstado().equals("reservado")) { //si el estado es reservado, seteo el valor y lo sumo al que tiene estado pago
                    Pagos pago = pagosRepository.findCentrosByRut(reservas.get(i).getActividades().getActividadesKey().getCentrosDeportivos().getRut(), reservas.get(i).getReservasKey().getEmpleados().getEmpresas().getRut());
                    long pagoAcumulado = pago.getGasto();
                    int nuevoPago = reservas.get(i).getActividades().getPrecio();
                    long gastoSet=pagoAcumulado + nuevoPago;
                    pago.setGasto(gastoSet);
                    reservas.get(i).setEstado("pagado");

                }
            }else {
                PagosKey pagosKey = new PagosKey(reservas.get(i).getReservasKey().getEmpleados().getEmpresas(), reservas.get(i).getActividades().getActividadesKey().getCentrosDeportivos());
                Pagos pagos1 = new Pagos(reservas.get(i).getActividades().getPrecio(), pagosKey);
                reservas.get(i).setEstado("pagado");
                pagosRepository.save(pagos1);
            }
        }
    }
}
