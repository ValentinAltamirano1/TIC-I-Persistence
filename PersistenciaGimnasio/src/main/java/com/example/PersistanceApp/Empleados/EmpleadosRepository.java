package com.example.PersistanceApp.Empleados;

import com.example.PersistanceApp.Actividades.ActividadesKey;
import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.Empresas.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados,String> {
    @Query("SELECT e FROM Empleados e WHERE e.pasaporte = ?1")
    Optional<Empleados> findEmpleadoByPasaporte(String pasaporte);

    @Query("SELECT d FROM Empleados d WHERE d.mail = ?1")
    List<Empleados> findEmpleadoByMail(String mail);

    @Query("SELECT e FROM Empleados e WHERE e.empresas.mail=?1 ")
    List<Empleados> findEmpleadoByEmpresa(String mailEmpresa);

    @Query("SELECT e FROM Empleados e WHERE e.pasaporte = ?1")
    List<Empleados> findEmpleadoByPasaport(String pasaporte);


}
