package com.example.PersistanceApp.Empleados;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados,String> {
    @Query("SELECT e FROM Empleados e WHERE e.pasaporte = ?1")
    Optional<Empleados> findEmpleadoByPasaporte(String pasaporte);

}
