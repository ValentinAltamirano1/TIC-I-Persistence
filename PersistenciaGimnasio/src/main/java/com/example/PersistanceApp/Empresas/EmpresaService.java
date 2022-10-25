package com.example.PersistanceApp.Empresas;

import com.example.PersistanceApp.Usuario.Usuarios;
import com.example.PersistanceApp.Usuario.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private EmpresaRepository EmpresaRepository;

    private UsuariosService usuariosService;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository, UsuariosService usuariosService) {
        this.EmpresaRepository = empresaRepository;
        this.usuariosService = usuariosService;
    }

    public List<Empresas> getEmpresa(){return EmpresaRepository.findAll(); //devuelve lista
    }
    public void addNewEmpresa(Empresas empresa) {
        Optional<Empresas> empresaByRut = EmpresaRepository.findEmpresaByRut(empresa.getRut());
        Usuarios usuario = new Usuarios(empresa.getMail(),empresa.getContra(),empresa.getTipo());
        if(empresaByRut.isPresent()){
            try {
                throw new IllegalAccessException("Centro Deportivo ingresado");
            } catch (IllegalAccessException e) {

            }
        }
        usuariosService.addNewUsuario(usuario);
        EmpresaRepository.save(empresa);
    }
}
