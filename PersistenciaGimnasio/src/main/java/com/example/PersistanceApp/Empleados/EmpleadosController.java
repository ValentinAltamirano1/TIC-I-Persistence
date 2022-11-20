package com.example.PersistanceApp.Empleados;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivosService;
import com.example.PersistanceApp.Empresas.Empresas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/gimnasio/empleado")
public class EmpleadosController {
    private final EmpleadosService empleadosService;

    @Autowired
    public EmpleadosController(EmpleadosService empleadosService){
        this.empleadosService = empleadosService;}
    @GetMapping("/{mail}")
    public List<Empleados> getEmpleado(@PathVariable("mail") String mail){
        return empleadosService.getEmpleado(mail);
    }

    @GetMapping("/pasaporte/{pasaporte}")
    public List<Empleados> getEmpleadoPasaporte(@PathVariable("pasaporte") String pasaporte){
        return empleadosService.getEmpleadoPorPasaporte(pasaporte);
    }
    @GetMapping
    public List<Empleados> getEmpleado(){
        return empleadosService.getEmpleado();
    }

    @GetMapping("/mailEmpresa/{mail}")
    public List<Empleados> getEmpleadoPorEmpresas(@PathVariable("mail") String mailEmpresa){
        return empleadosService.getEmpleadoPorEmpresa(mailEmpresa);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevoEmpleado(@RequestBody Empleados empleados){
        empleadosService.addNewEmpleado(empleados);
    }

    @DeleteMapping(path = "{pasaporte}")
    public void deleteEmpleados(@PathVariable("pasaporte") String pasaporte){
        empleadosService.deleteEmpleado(pasaporte);
    }



}
