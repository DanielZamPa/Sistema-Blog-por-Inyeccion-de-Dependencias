package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Autor;
import com.Sistema_basico_Blog.miBlog.modelo.Posteo;
import com.Sistema_basico_Blog.miBlog.repository.IautorRepository;
import com.Sistema_basico_Blog.miBlog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IposteoService {
    private IposteoRepository posteoRepository;
    private IautorRepository autorRepository;

    @Autowired
    public PosteoService(IposteoRepository posteoRepository, IautorRepository autorRepository) {
        this.posteoRepository = posteoRepository;
        this.autorRepository = autorRepository;
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
        // CORRECCIÓN: Lógica para asociar el autor antes de guardar.
        if (posteo.getAutor() != null && posteo.getAutor().getId() != null) {
            // Busca el autor en la base de datos usando el ID que viene en el JSON.
            Autor autor = autorRepository.findById(posteo.getAutor().getId())
                    .orElseThrow(() -> new RuntimeException("Autor no encontrado con id: " + posteo.getAutor().getId()));
            // Asigna el autor completo (obtenido de la BD) al posteo.
            posteo.setAutor(autor);
        } else {
            // Si no se proporciona un autor, lanza un error.
            throw new RuntimeException("El autor es requerido para crear un posteo.");
        }
        // Guarda el posteo con la relación ya establecida.
        return posteoRepository.save(posteo);
    }

    @Override
    public void deleteById(Long id) {
        posteoRepository.deleteById(id);
    }

    @Override
    public Optional<Posteo> update(Long id, Posteo posteo) {
        return posteoRepository.findById(id)
                .map(existingPost -> {
                    existingPost.setTitulo(posteo.getTitulo());
                    // La lógica para actualizar el autor podría ser más compleja,
                    // por ahora solo actualizamos el título.
                    return posteoRepository.save(existingPost);
                });
    }
}
