package com.example.PersistanceApp.Empleados;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService {
    private final EmpleadosRepository empleadosRepository;

    @Autowired
    public EmpleadosService (EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

    public List<Empleados> getEmpleado(){return empleadosRepository.findAll(); //devuelve lista
    }

    public void addNewEmpleado(Empleados empleados) {
        Optional<Empleados> empleadoByPasaporte = empleadosRepository.findEmpleadoByPasaporte(empleados.getPasaporte());
        if(empleadoByPasaporte.isPresent()){
            try {
                throw new IllegalAccessException("Centro Deportivo ingresado");
            } catch (IllegalAccessException e) {

            }
        }
        empleadosRepository.save(empleados);
    }
}
