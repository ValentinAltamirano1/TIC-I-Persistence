package com.example.PersistanceApp.Imagen;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Imagenes,Long> {
    @Override
    Optional<Imagenes> findById(Long id);
}
