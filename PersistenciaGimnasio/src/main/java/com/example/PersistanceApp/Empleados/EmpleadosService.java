package com.example.PersistanceApp.Empleados;


import com.example.PersistanceApp.Empresas.Empresas;
import com.example.PersistanceApp.Usuario.Usuarios;
import com.example.PersistanceApp.Usuario.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService {

    private EmpleadosRepository empleadosRepository;
    private UsuariosService usuariosService;

    @Autowired
    public EmpleadosService (EmpleadosRepository empleadosRepository, UsuariosService usuariosService) {
        this.empleadosRepository = empleadosRepository;
        this.usuariosService= usuariosService;
    }

    public List<Empleados> getEmpleado(String mail){return empleadosRepository.findEmpleadoByMail(mail);}
    public List<Empleados> getEmpleado(){return empleadosRepository.findAll(); //devuelve lista
    }

    public List<Empleados> getEmpleadoPorEmpresa(String mailEmpresa){return empleadosRepository.findEmpleadoByEmpresa(mailEmpresa); //devuelve lista
    }

    public List<Empleados> getEmpleadoPorPasaporte(String pasaporte){return empleadosRepository.findEmpleadoByPasaport(pasaporte); //devuelve lista
    }

    public void addNewEmpleado(Empleados empleados) {
        Optional<Empleados> empleadoByPasaporte = empleadosRepository.findEmpleadoByPasaporte(empleados.getPasaporte());
        Usuarios usuario = new Usuarios(empleados.getMail(),empleados.getContraseña(),empleados.getTipo());
        String vencimiento_ficha= empleados.getFicha_medica();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaV = LocalDate.parse(vencimiento_ficha, formatter);

        if (fechaV.isBefore(java.time.LocalDate.now())){
            return;
          }
        else{
            if(empleadoByPasaporte.isPresent()){
                try {
                    throw new IllegalAccessException("Empleado ya ingresado");
                } catch (IllegalAccessException e) {}
            }
        }

        usuariosService.addNewUsuario(usuario);
        empleadosRepository.save(empleados);
    }
    public void deleteEmpleado(String pasaporte){
        boolean existe=empleadosRepository.existsById(pasaporte);
        if (!existe){
            throw new IllegalStateException("empleado con pasaporte"+ pasaporte + "no existe");
        }
        empleadosRepository.deleteById(pasaporte);
    }

}
