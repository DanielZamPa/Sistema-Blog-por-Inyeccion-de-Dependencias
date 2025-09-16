package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Comentario;

import java.util.List;
import java.util.Optional;

public interface IcomentarioService {
    List<Comentario> findAll();
    Optional<Comentario> findById(Long id);
    Comentario save(Comentario comentario);
    void deleteById(Long id);
    Optional<Comentario> update(Long id, Comentario posteoDetails);
}//Cierre de interfaz
