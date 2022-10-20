package com.example.PersistanceApp.Empleados;

import com.example.PersistanceApp.Usuario.Usuarios;
import com.example.PersistanceApp.Usuario.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService {
    private EmpleadosRepository empleadosRepository;

    private UsuariosService usuariosService;

    public EmpleadosService(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @Autowired
    public EmpleadosService (EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

    public List<Empleados> getEmpleado(){return empleadosRepository.findAll(); //devuelve lista
    }

    public void addNewEmpleado(Empleados empleados) {
        Optional<Empleados> empleadoByPasaporte = empleadosRepository.findEmpleadoByPasaporte(empleados.getPasaporte());
        Usuarios usuario = new Usuarios(empleados.getMail(),empleados.getContraseña(),empleados.getTipo());
        if(empleadoByPasaporte.isPresent()){
            try {
                throw new IllegalAccessException("Centro Deportivo ingresado");
            } catch (IllegalAccessException e) {

            }
        }
        usuariosService.addNewUsuario(usuario);
        empleadosRepository.save(empleados);
    }



}
