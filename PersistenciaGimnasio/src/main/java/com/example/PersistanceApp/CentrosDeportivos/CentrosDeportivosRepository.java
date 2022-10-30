package com.example.PersistanceApp.CentrosDeportivos;

import com.example.PersistanceApp.Empresas.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CentrosDeportivosRepository extends JpaRepository<CentrosDeportivos,Long> {

    @Query("SELECT d FROM CentrosDeportivos d WHERE d.rut = ?1")
    Optional<CentrosDeportivos>findCentroDeportivoByRut(Long rut);
    @Query("SELECT d FROM CentrosDeportivos d WHERE d.mail = ?1")
    List<CentrosDeportivos> findCentrosDeportivosByMail(String mail);


}