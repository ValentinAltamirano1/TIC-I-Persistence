package com.example.PersistanceApp.Usuario;

import com.example.PersistanceApp.Empresas.EmpresaRepository;
import com.example.PersistanceApp.Empresas.Empresas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    private final UsuariosRespository usuariosRepository;


    @Autowired
    public UsuariosService(UsuariosRespository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public List<Usuarios> getUsuario(){return usuariosRepository.findAll(); //devuelve lista
    }

    public void addNewUsuario(Usuarios usuarios) {
        Optional<Usuarios> usuarioByMail = usuariosRepository.findUsuariosByMail(usuarios.getMail());
        if(usuarioByMail.isPresent()){
            try {
                throw new IllegalAccessException("Usuario ingresado");
            } catch (IllegalAccessException e) {

            }
        }
        usuariosRepository.save(usuarios);
    }

}
