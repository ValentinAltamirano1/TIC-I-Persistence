package com.example.PersistanceApp.CentrosDeportivos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentrosDeportivosService {

    private final CentrosDeportivosRepository centrosDeportivosRepository;

    @Autowired
    public CentrosDeportivosService(CentrosDeportivosRepository centrosDeportivosRepository) {
        this.centrosDeportivosRepository = centrosDeportivosRepository;
    }

    public List<CentrosDeportivos> getCentroDeportivo(){return centrosDeportivosRepository.findAll(); //devuelve lista
    }

    public void addNewCentroDeportivo(CentrosDeportivos centrosDeportivos) {
        Optional<CentrosDeportivos> centrosByDireccion = centrosDeportivosRepository.findCentroDeportivoByDireccion(centrosDeportivos.getRut());
        if(centrosByDireccion.isPresent()){
            try {
                throw new IllegalAccessException("Centro Deportivo ingresado");
            } catch (IllegalAccessException e) {

            }
        }
        centrosDeportivosRepository.save(centrosDeportivos);
    }
}
