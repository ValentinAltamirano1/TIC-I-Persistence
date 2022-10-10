package com.example.PersistanceApp.Usuario;

import com.example.PersistanceApp.Usuario.Usuarios;
import com.example.PersistanceApp.Usuario.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/gimnasio/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService){
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> getUsuario(){
        return usuariosService.getUsuario();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void registrarNuevoUsuario(@RequestBody Usuarios usuarios){
        usuariosService.addNewUsuario(usuarios);
    }

}