package com.example.PersistanceApp.Pagos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/gimnasio/pagos")
public class PagosController {
    private final PagosService pagosService;

    @Autowired
    public PagosController(PagosService pagosService) {
        this.pagosService = pagosService;
    }

    @GetMapping
    public List<Pagos> getPagos(){
        return pagosService.getPagos();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevoPago(){
        pagosService.addNewPago();
    }

}
