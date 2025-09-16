package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Autor;

import java.util.List;
import java.util.Optional;

public interface IautorService {
    List<Autor> findAll();
    Optional<Autor> findById(Long id);
    Autor save(Autor autor);
    void deleteById(Long id);
    Optional<Autor> update(Long id, Autor posteoDetails);
}//Cierre de interfaz
