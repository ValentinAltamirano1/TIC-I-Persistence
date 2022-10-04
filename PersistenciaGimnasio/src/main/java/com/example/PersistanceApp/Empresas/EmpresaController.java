package com.example.PersistanceApp.Empresas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/gimnasio/empresa")
public class EmpresaController {
    private final EmpresaService empresas;

    @Autowired
    public EmpresaController(EmpresaService empresaService){
        this.empresas = empresaService;
    }

    @GetMapping
    public List<Empresas> getEmpresas(){
        return empresas.getEmpresa();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevoCentroDeportivo(@RequestBody Empresas empresa){
        empresas.addNewEmpresa(empresa);
    }
}
