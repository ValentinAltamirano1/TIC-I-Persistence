package com.example.PersistanceApp.CentrosDeportivos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentrosDeportivosRepository extends JpaRepository<CentrosDeportivos,Long> {

    @Query("SELECT d FROM CentrosDeportivos d WHERE d.rut = ?1")
    Optional<CentrosDeportivos>findCentroDeportivoByRut(Long rut);

}