package com.Sistema_basico_Blog.miBlog.repository;

import com.Sistema_basico_Blog.miBlog.modelo.Posteo;

import java.util.List;

public interface IposteoRepository {
    List<Posteo> findAll();
    Posteo findById(Long id);
    void save(Posteo posteo);
}
