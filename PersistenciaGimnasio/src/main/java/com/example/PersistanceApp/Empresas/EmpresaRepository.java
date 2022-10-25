package com.example.PersistanceApp.Empresas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmpresaRepository extends JpaRepository<Empresas,Long> {

    @Query("SELECT r FROM Empresas r WHERE r.rut = ?1")
    Optional<Empresas> findEmpresaByRut(Long rut);


}

