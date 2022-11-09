package com.example.PersistanceApp.Actividades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface ActividadesRepository extends JpaRepository<Actividades, String> {
    /*@Query(value = "SELECT a.actividadesKey FROM Actividades a WHERE a.actividadesKey.centrosDeportivos = ?1 AND a.actividadesKey.nombre = ?1 AND a.actividadesKey.horario = ?1")
    Optional<Actividades> findActivitiesByKey(ActividadesKey actividadesKey);*/

    @Query(value= "SELECT a FROM Actividades a INNER JOIN a.actividadesKey.centrosDeportivos c WHERE c.mail=?1")
    List<Actividades> findActividadesByCentro (String mail);

    @Query(value = "SELECT * FROM Actividades d WHERE d.categoria = ?1", nativeQuery = true)
    List<Actividades> findActivitiesByCategorise(String cateogria);

}
