package com.Sistema_basico_Blog.miBlog.controller;

import com.Sistema_basico_Blog.miBlog.modelo.Posteo;
import com.Sistema_basico_Blog.miBlog.service.PosteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posteos")
public class PosteoController {
    private PosteoService posteoService;

    @Autowired
    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> findAll() {
        return posteoService.findAll();
    }

    @GetMapping("/{id}")
    public Posteo obtenerPorId(@PathVariable Long id){
        return posteoService.findById(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String>guardarPost(@RequestBody Posteo post){
        posteoService.save(post);
        return ResponseEntity.ok("Post creado correctamente");
    }

}//Cierre de clase Controller
