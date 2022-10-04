package com.example.PersistanceApp.Empresas;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository EmpresaRepository;


    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.EmpresaRepository = empresaRepository;
    }

    public List<Empresas> getEmpresa(){return EmpresaRepository.findAll(); //devuelve lista
    }
    public void addNewEmpresa(Empresas empresas) {
        Optional<Empresas> empresaByRut = EmpresaRepository.findEmpresaByRut(empresas.getRut());
        if(empresaByRut.isPresent()){
            try {
                throw new IllegalAccessException("Centro Deportivo ingresado");
            } catch (IllegalAccessException e) {

            }
        }
        EmpresaRepository.save(empresas);
    }
}
