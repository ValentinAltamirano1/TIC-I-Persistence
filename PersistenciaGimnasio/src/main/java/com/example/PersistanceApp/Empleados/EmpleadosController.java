package com.example.PersistanceApp.Empleados;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivosService;
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

    @GetMapping
    public List<Empleados> getEmpleado(){
        return empleadosService.getEmpleado();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevoEmpleado(@RequestBody Empleados empleados){
        empleadosService.addNewEmpleado(empleados);
    }
}
