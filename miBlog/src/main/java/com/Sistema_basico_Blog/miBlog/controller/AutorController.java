package com.Sistema_basico_Blog.miBlog.controller;

import com.Sistema_basico_Blog.miBlog.modelo.Autor;
import com.Sistema_basico_Blog.miBlog.service.IautorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private IautorService autorService;

    @Autowired
    public AutorController(IautorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> findAll() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public Autor obtenerPorId(@PathVariable Long id){
        return autorService.findById(id).orElse(null);
    }

    @PostMapping("/crear")
    public Autor guardarAutor(Autor autor){
        return autorService.save(autor);
    }

    @PutMapping("/editar/{id}")
    public Autor actualizarAutor(@PathVariable Long id, Autor autor) {
        return autorService.update(id, autor).orElse(null);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarAutor(@PathVariable Long id) {
        autorService.deleteById(id);
    }
}//Cierre de clase controller
