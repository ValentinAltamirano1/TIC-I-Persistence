package com.example.PersistanceApp.Actividades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface ActividadesRepository extends JpaRepository<Actividades, String> {
    @Query("SELECT d FROM Actividades d WHERE d.nombre = ?1")
    Optional<Actividades>findActividadesByNombre(String nombre);
}
