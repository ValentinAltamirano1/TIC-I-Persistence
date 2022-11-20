package com.example.PersistanceApp.Pagos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PagosRepository extends JpaRepository<Pagos,PagosKey> {
    @Query("SELECT p FROM Pagos p WHERE p.pagosKey.centrosDeportivos.rut = ?1 and p.pagosKey.empresas.rut=?2")
    List<Pagos> findCentroByRut(Long rutc, Long rute);
}
