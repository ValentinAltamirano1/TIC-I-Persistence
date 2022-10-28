package com.example.PersistanceApp.Actividades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface ActividadesRepository extends JpaRepository<Actividades, String> {
    @Query("SELECT a FROM Actividades a WHERE a.id_actividad = ?1")
    Optional<Actividades>findActividadesById(Integer id);
    @Query("SELECT d FROM Actividades d WHERE d.categoria = ?1")
    List<Actividades> findActividadesByCategoria(String cateogria);
}
