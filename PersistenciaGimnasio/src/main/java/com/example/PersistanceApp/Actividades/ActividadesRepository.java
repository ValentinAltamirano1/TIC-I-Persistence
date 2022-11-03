package com.example.PersistanceApp.Actividades;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface ActividadesRepository extends JpaRepository<Actividades, String> {
   // @Query(value = "SELECT a FROM Actividades a WHERE a.centros_deportivos_rut = ?1 AND a.nombre = ?1 AND a.horario = ?1 AND a.fecha =?1",nativeQuery = true)
    //Optional<Actividades> findActividadesByKey(ActividadesKey actividadesKey);
    @Query(value = "SELECT * FROM Actividades d WHERE d.categoria = ?1", nativeQuery = true)
    List<Actividades> findActividadesByCategoria(String cateogria);
}
