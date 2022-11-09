/*package com.example.PersistanceApp.Horario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
    @Query("SELECT h FROM Horario h WHERE h.horarioKey.dia_de_semana = ?1 AND h.horarioKey.horario_inicio=?1 AND h.horarioKey.horario_fin=?1")
    Optional<Horario> findHorarioByHorarioKey(String dia_de_semana, String horario_inicio, String horario_fin);
}
*/