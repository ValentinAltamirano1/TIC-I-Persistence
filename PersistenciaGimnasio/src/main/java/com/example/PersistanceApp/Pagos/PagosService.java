package com.example.PersistanceApp.Pagos;

import com.example.PersistanceApp.Empresas.Empresas;
import com.example.PersistanceApp.Usuario.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagosService {
    private PagosRepository pagosRepository;

    @Autowired
    public PagosService(PagosRepository pagosRepository) {
        this.pagosRepository = pagosRepository;
    }
    public List<Pagos> getPagos(){return pagosRepository.findAll(); //devuelve lista
    }
    public void addNewPago(Pagos pagos) {
        List<Pagos> empresaByPago = pagosRepository.findCentroByRut(pagos.getPagosKey().getCentrosDeportivos().getRut(),pagos.getPagosKey().getEmpresas().getRut());
        //es necesario lo de arriba??
        pagosRepository.save(pagos);
    }
}
