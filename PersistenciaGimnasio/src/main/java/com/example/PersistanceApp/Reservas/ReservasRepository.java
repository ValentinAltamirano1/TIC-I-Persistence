package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empleados.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Actividades> {

    @Query(value = "SELECT r.actividades FROM Reservas r inner join r.reservasKey.empleados e where e.pasaporte = ?1")
    List<Actividades> findActivitiesByPassport(String pasporte);


    @Query(value = "SELECT r.actividades FROM Reservas r inner join r.actividades e where e.actividadesKey.centrosDeportivos.rut = ?1")
    List<Actividades> findActivitiesByRut(Long rut);

    @Query(value = "SELECT r FROM Reservas r inner join r.actividades a where a.actividadesKey.centrosDeportivos.mail=?1")
    List<Reservas> findReservasByMail(String mail);


}
