package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Posteo;
import com.Sistema_basico_Blog.miBlog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IposteoService {
    private IposteoRepository posteoRepository;

    @Autowired
    public PosteoService(IposteoRepository posteoRepository) {
        this.posteoRepository = posteoRepository;
    }

    @Override
    public List<Posteo> findAll() {
        return posteoRepository.findAll();
    }

    @Override
    public Optional<Posteo> findById(Long id) {
        return posteoRepository.findById(id);
    }

    @Override
    public Posteo save(Posteo posteo) {
        return posteoRepository.save(posteo);
    }

    @Override
    public void deleteById(Long id) {
        posteoRepository.deleteById(id);
    }

    @Override
    public Optional<Posteo> update(Long id, Posteo posteo) {
        Optional<Posteo> posteoOptional = posteoRepository.findById(id);
        if (posteoOptional.isPresent()) {
            Posteo posteoActualizado = posteoOptional.get();
            posteoActualizado.setTitulo(posteo.getTitulo());
            posteoActualizado.setAutor(posteo.getAutor());
            posteoRepository.save(posteoActualizado);
            return Optional.of(posteoActualizado);
        } else {
            return Optional.empty();
        }
    }
}
