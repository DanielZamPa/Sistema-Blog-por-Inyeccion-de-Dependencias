package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Comentario;
import com.Sistema_basico_Blog.miBlog.repository.IcomentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        return comentarioRepository.findById(id);
    }

    @Override
    public Comentario save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public void deleteById(Long id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public Optional<Comentario> update(Long id, Comentario comentarioDetails) {
        Optional<Comentario> cometarioOptional = comentarioRepository.findById(id);
        if (cometarioOptional.isPresent()) {
            Comentario comentarioActualizado = cometarioOptional.get();
            comentarioActualizado.setText(comentarioDetails.getText());
            comentarioActualizado.setCreatedAt(comentarioDetails.getCreatedAt());
            comentarioRepository.save(comentarioActualizado);
            return Optional.of(comentarioActualizado);
        } else {
            return Optional.empty();
        }
    }
}
