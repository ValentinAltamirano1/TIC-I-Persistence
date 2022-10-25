package com.example.PersistanceApp.Usuario;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity check(String mail, String contraseña) throws JsonProcessingException {
        Optional<Usuarios> registrado = usuariosRepository.findUsuariosByMail(mail);
        if(registrado.isEmpty() || !registrado.get().getContraseña().equals(contraseña)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        else{
            registrado.get().setContraseña(null);
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = mapper.createObjectNode();
            node.put("tipoUsuario", registrado.get().getTipoUsuario());
            node.put("mail", registrado.get().getMail());
            node.put("contraseña", registrado.get().getContraseña());
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
            return new ResponseEntity(json, HttpStatus.ACCEPTED);
        }
    }

    public List<Usuarios> getUsuario(){return usuariosRepository.findAll(); //devuelve lista
    }

    public void addNewUsuario(Usuarios usuarios) {
        /*Optional<Usuarios> usuarioByMail = usuariosRepository.findUsuariosByMail(usuarios.getMail());
        if(usuarioByMail.isPresent()){
            try {
                throw new IllegalAccessException("Usuario ingresado");
            } catch (IllegalAccessException e) {

            }
        }*/
        usuariosRepository.save(usuarios);
    }

}
