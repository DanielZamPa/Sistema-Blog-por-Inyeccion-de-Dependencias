package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Autor;

import java.util.List;
import java.util.Optional;

public class AutorService implements IautorService{
    @Override
    public List<Autor> findAll() {
        return List.of();
    }

    @Override
    public Optional<Autor> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Autor save(Autor autor) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Autor> update(Long id, Autor posteoDetails) {
        return Optional.empty();
    }
}
