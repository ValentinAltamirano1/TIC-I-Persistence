package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Actividades.ActividadesKey;
import com.example.PersistanceApp.Empleados.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Actividades> {

    @Query(value = "SELECT r.actividades FROM Reservas r inner join r.reservasKey.empleados e where e.pasaporte = ?1")
    List<Actividades> findActivitiesByPassport(String pasporte);


    @Query(value = "SELECT r.actividades FROM Reservas r inner join r.actividades e where e.actividadesKey.centrosDeportivos.rut = ?1")
    List<Actividades> findActivitiesByRut(Long rut);

    @Query(value = "SELECT r FROM Reservas r inner join r.actividades a where a.actividadesKey.centrosDeportivos.mail=?1 AND r.asistio=FALSE ")
    List<Reservas> findReservasByMail(String mail);// reservas con condicion de asistio = false

    @Query(value = "SELECT r FROM Reservas r where r.asistio=TRUE ")
    List<Reservas> findReservaByMail();// reservas con condicion de asistio = true

    @Query(value = "SELECT r FROM Reservas r where r.reservasKey=?1")
    Optional<Reservas> findReservasByKey (ReservasKey reservasKey);


    @Transactional
    @Modifying()
    @Query(value = "update Reservas r set r.asistio=TRUE where r.reservasKey=?1")
    void updateReservaExistente(ReservasKey reservasKey);
}
