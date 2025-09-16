package com.Sistema_basico_Blog.miBlog.repository;

import com.Sistema_basico_Blog.miBlog.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IautorRepository extends JpaRepository<Autor, Long> {}
