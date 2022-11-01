package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empleados.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Empleados> {

    /*@Query("SELECT r FROM Empresas r WHERE r.rut = ?1")
    Optional<Reservas> findEmpresaByEmpleado(Empleados empleados);*/

    @Query(value = "SELECT r.actividades FROM Reservas r inner join r.reservasKey.empleados e where e.pasaporte = ?1")
    List<Actividades> findActivitiesByPassport(String pasporte);


}
