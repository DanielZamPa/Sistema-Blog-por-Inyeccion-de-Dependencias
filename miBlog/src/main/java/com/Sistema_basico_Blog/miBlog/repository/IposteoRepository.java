package com.Sistema_basico_Blog.miBlog.repository;

import com.Sistema_basico_Blog.miBlog.modelo.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IposteoRepository extends JpaRepository<Posteo, Long> {
    // Al extender JpaRepository, ya tienes acceso a todos los métodos CRUD básicos.
    // No es necesario declararlos aquí a menos que quieras crear una consulta personalizada.
}
