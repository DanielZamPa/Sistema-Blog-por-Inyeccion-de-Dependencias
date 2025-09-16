package com.Sistema_basico_Blog.miBlog.controller;

import com.Sistema_basico_Blog.miBlog.modelo.Posteo;
import com.Sistema_basico_Blog.miBlog.service.IposteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posteos")
public class PosteoController {
    // 1. Inyectamos la interfaz en lugar de la clase concreta. Es una mejor práctica.
    private IposteoService posteoService;

    @Autowired
    public PosteoController(IposteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> findAll() {
        return posteoService.findAll();
    }

    @GetMapping("/{id}")
    // 2. Cambiamos el tipo de retorno a ResponseEntity para tener control total sobre la respuesta HTTP.
    public ResponseEntity<Posteo> obtenerPorId(@PathVariable Long id){
        Optional<Posteo> posteoOptional = posteoService.findById(id);

        // 3. Verificamos si el Optional contiene un valor.
        if (posteoOptional.isPresent()) {
            // Si existe, devolvemos el posteo con un estado 200 OK.
            return ResponseEntity.ok(posteoOptional.get());
        } else {
            // Si no existe, devolvemos un estado 404 Not Found.
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    // 4. Devolvemos un estado 201 Created, que es el estándar para la creación de recursos.
    public ResponseEntity<Posteo> guardarPost(@RequestBody Posteo post){
        Posteo posteoGuardado = posteoService.save(post);
        return new ResponseEntity<>(posteoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Posteo> actualizarPost(@PathVariable Long id, @RequestBody Posteo posteo){
        Optional<Posteo> posteoActualizado = posteoService.update(id, posteo);
        if (posteoActualizado.isPresent()) {
            return ResponseEntity.ok(posteoActualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPost(@PathVariable Long id){
        // Verificamos primero si el posteo existe para evitar errores y dar una respuesta 404 si no se encuentra.
        if (posteoService.findById(id).isPresent()) {
            posteoService.deleteById(id);
            // 204 No Content es la respuesta estándar para un borrado exitoso. No lleva cuerpo.
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}//Cierre de clase Controller
