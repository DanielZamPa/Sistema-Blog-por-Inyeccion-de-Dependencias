package com.Sistema_basico_Blog.miBlog.service;

import com.Sistema_basico_Blog.miBlog.modelo.Autor;
import com.Sistema_basico_Blog.miBlog.repository.IautorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IautorService{
    private IautorRepository autorRepository;

    @Autowired
    public AutorService(IautorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public Optional<Autor> update(Long id, Autor autorDetails) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if (autorOptional.isPresent()) {
            Autor autorActualizado = autorOptional.get();
            autorActualizado.setName(autorDetails.getName());
            autorActualizado.setEmail(autorDetails.getEmail());
            autorRepository.save(autorActualizado);
            return Optional.of(autorActualizado);
        } else {
            return Optional.empty();
        }
    }
}
