package com.Sistema_basico_Blog.miBlog.controller;

import com.Sistema_basico_Blog.miBlog.modelo.Comentario;
import com.Sistema_basico_Blog.miBlog.service.IcomentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// 1. Cambiamos la ruta base para que sea coherente con el recurso que maneja.
@RequestMapping("/comentarios")
public class ComentarioController {
    // 2. Inyectamos el servicio correcto para manejar Comentarios.
    private IcomentarioService comentarioService;

    @Autowired
    public ComentarioController(IcomentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public List<Comentario> findAll() {
        return comentarioService.findAll();
    }

    @GetMapping("/{id}")
    // 3. Usamos ResponseEntity para un mejor control de las respuestas HTTP (ej. 404 Not Found).
    public ResponseEntity<Comentario> obtenerPorId(@PathVariable Long id){
        return comentarioService.findById(id)
                .map(ResponseEntity::ok) // Si se encuentra, devuelve 200 OK con el comentario.
                .orElse(ResponseEntity.notFound().build()); // Si no, devuelve 404 Not Found.
    }

    @PostMapping("/crear")
    // 4. Añadimos @RequestBody para que Spring tome los datos del cuerpo JSON de la petición.
    //    Devolvemos 201 Created, que es el estándar para la creación de recursos.
    public ResponseEntity<Comentario> guardarComentario(@RequestBody Comentario comentario){
        Comentario comentarioGuardado = comentarioService.save(comentario);
        return new ResponseEntity<>(comentarioGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        return comentarioService.update(id, comentario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    // 5. Devolvemos 204 No Content para borrados exitosos, o 404 si no se encuentra.
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        if (comentarioService.findById(id).isPresent()) {
            comentarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}//Cierre de clase controller
