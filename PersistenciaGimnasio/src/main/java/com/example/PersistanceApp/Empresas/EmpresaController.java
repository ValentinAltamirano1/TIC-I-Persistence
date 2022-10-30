package com.example.PersistanceApp.Empresas;
import com.example.PersistanceApp.Actividades.Actividades;
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

    @GetMapping("/{mail}")
    public List<Empresas> getEmpresa(@PathVariable("mail") String mail){
        System.out.println(mail);
        return empresas.getEmpresa(mail);
    }

    @GetMapping
    public List<Empresas> getEmpresas(){
        System.out.println(empresas.getEmpresa());
        return empresas.getEmpresa();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevoCentroDeportivo(@RequestBody Empresas empresa){
        empresas.addNewEmpresa(empresa);
    }
}