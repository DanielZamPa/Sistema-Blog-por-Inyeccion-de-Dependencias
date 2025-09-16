package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Posteo;

import java.util.List;
import java.util.Optional;

public interface IposteoService {
    List<Posteo> findAll();
    Optional<Posteo> findById(Long id);
    // Cambiamos void a Posteo para que devuelva la entidad guardada (con su ID)
    Posteo save(Posteo posteo);

    // Nuevo método para eliminar un posteo por su ID
    void deleteById(Long id);

    // Nuevo método para actualizar un posteo
    Optional<Posteo> update(Long id, Posteo posteoDetails);
}