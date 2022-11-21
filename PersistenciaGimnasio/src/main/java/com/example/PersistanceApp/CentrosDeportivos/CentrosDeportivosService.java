package com.example.PersistanceApp.CentrosDeportivos;

import com.example.PersistanceApp.Empresas.Empresas;
import com.example.PersistanceApp.Usuario.Usuarios;
import com.example.PersistanceApp.Usuario.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentrosDeportivosService {

    private CentrosDeportivosRepository centrosDeportivosRepository;

    private UsuariosService usuariosService;

    @Autowired
    public CentrosDeportivosService(CentrosDeportivosRepository centrosDeportivosRepository, UsuariosService usuariosService) {
        this.centrosDeportivosRepository = centrosDeportivosRepository;
        this.usuariosService = usuariosService;
    }

    public List<CentrosDeportivos> getCentroDeportivo(String mail){
        return centrosDeportivosRepository.findCentrosDeportivosByMail(mail);}

    public List<CentrosDeportivos> getCentroDeportivo(){
        return centrosDeportivosRepository.findAll(); //devuelve lista
    }

    public void addNewCentroDeportivo(CentrosDeportivos centrosDeportivos) {
        Optional<CentrosDeportivos> centrosByDireccion = centrosDeportivosRepository.findCentroDeportivoByRut(centrosDeportivos.getRut());
        Usuarios usuario = new Usuarios(centrosDeportivos.getMail(),centrosDeportivos.getContra(),centrosDeportivos.getTipo());
        if(centrosByDireccion.isPresent()){
            try {
                throw new IllegalAccessException("Centro Deportivo ya ingresado");
            } catch (IllegalAccessException e) {

            }
        }
        usuariosService.addNewUsuario(usuario);
        centrosDeportivosRepository.save(centrosDeportivos);
    }
    public void deleteCentroDeportivo(Long rut){
        boolean existe=centrosDeportivosRepository.existsById(rut);
        if (!existe){
            throw new IllegalStateException("centro con rut"+ rut + " no existe");
        }
        centrosDeportivosRepository.deleteById(rut);



    }
}