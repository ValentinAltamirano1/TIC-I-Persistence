package com.example.PersistanceApp.Usuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuariosRespository extends JpaRepository<Usuarios,String> {
    @Query("SELECT m FROM Usuarios m WHERE m.mail = ?1")
    Optional<Usuarios> findUsuariosByMail(String mail);

}
