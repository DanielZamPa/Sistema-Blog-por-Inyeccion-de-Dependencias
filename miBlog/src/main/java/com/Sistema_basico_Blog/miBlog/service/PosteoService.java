package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Posteo;
import com.Sistema_basico_Blog.miBlog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteoService implements IposteoService{
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
    public Posteo findById(Long id) {
        return posteoRepository.findById(id);
    }

    @Override
    public void save(Posteo posteo) {
        posteoRepository.save(posteo);
    }
}
