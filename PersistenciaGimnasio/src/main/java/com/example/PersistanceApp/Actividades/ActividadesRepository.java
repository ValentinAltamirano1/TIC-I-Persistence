package com.example.PersistanceApp.Actividades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface ActividadesRepository extends JpaRepository<Actividades, String> {
    @Query("SELECT d FROM Actividades d WHERE d.nombre = ?1")
    Optional<Actividades>findActividadesByNombre(String nombre);
    @Query("SELECT d FROM Actividades d WHERE d.categoria = ?1")
    List<Actividades> findActividadesByCategoria(String cateogria);
}
