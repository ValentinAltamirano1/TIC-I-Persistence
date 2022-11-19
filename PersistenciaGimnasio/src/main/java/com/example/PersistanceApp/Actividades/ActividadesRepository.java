package com.example.PersistanceApp.Actividades;

import com.example.PersistanceApp.Horario.HorarioKey;
import com.example.PersistanceApp.Imagen.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ActividadesRepository extends JpaRepository<Actividades, String> {
    @Query(value = "SELECT h FROM Actividades a  INNER JOIN a.horarios h WHERE a.actividadesKey.centrosDeportivos.rut= ?1 AND a.actividadesKey.nombre=?2 AND a.capacidad=?3 AND a.cupos=?4 AND a.categoria=?5 And a.descripcion=?6  AND a.precio=?7")
    List<HorarioKey> findActivitiesByHorarios(Long rut, String nombre, int capacidad, int cupos, String categoria, String descripcion,int Precio);

    @Query(value = "SELECT a FROM Actividades a  WHERE a.actividadesKey= ?1")
    Optional<Actividades> findActividadesByActividadesKey(ActividadesKey actividadesKey);

    @Query(value= "SELECT a FROM Actividades a INNER JOIN a.actividadesKey.centrosDeportivos c WHERE c.mail=?1")
    List<Actividades> findActividadesByCentro (String mail);

    @Query(value = "SELECT * FROM Actividades d WHERE d.categoria = ?1", nativeQuery = true)
    List<Actividades> findActivitiesByCategorise(String cateogria);

    @Query(value = "SELECT h FROM Actividades a INNER JOIN a.horarios h WHERE h.dia_de_semana=?1 AND a.actividadesKey.nombre= ?2 AND a.actividadesKey.centrosDeportivos.rut=?3 ")
    List<HorarioKey> findActivitiesByDiaSemanaNombreRut(String dia_semana, String nombre, Long rut);

    @Query(value = "SELECT a FROM Actividades a where a.actividadesKey.centrosDeportivos.nombre = ?1")
    List<Actividades> findActividadesByNombre(String nombre);

   /* @Query(value = "SELECT h FROM Actividades a INNER JOIN a.horarios h WHERE h.dia_de_semana=?1 AND a.actividadesKey.nombre=?2 AND a.actividadesKey.centrosDeportivos.rut=?3")
    List<Actividades> findActivitiesByCategori(String cateogria);*/




}
