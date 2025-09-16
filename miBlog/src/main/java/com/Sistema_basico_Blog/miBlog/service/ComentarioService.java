package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Comentario;
import com.Sistema_basico_Blog.miBlog.repository.IcomentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ComentarioService implements IcomentarioService{
    private IcomentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(IcomentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    @Override
    public Optional<Comentario> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Comentario save(Comentario comentario) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Comentario> update(Long id, Comentario posteoDetails) {
        return Optional.empty();
    }
}
