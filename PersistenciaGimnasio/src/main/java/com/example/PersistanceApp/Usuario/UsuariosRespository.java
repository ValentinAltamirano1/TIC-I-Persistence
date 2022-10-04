package com.example.PersistanceApp.Usuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuariosRespository extends JpaRepository<Usuarios,String> {
    @Query("SELECT d FROM Usuarios d WHERE d.mail = ?1")
    Optional<Usuarios> findUsuariosByMail(String mail);
}
