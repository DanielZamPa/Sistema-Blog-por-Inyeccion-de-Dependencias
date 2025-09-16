package com.Sistema_basico_Blog.miBlog.repository;

import com.Sistema_basico_Blog.miBlog.modelo.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcomentarioRepository extends JpaRepository<Comentario, Long> {}
