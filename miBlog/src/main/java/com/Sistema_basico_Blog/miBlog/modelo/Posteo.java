package com.Sistema_basico_Blog.miBlog.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Posteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonBackReference("posteos")
    private Autor autor;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference("comentariosPost")
    private List<Comentario> comentarios = new ArrayList<>();

    public Posteo() {
    }

    public Posteo(String titulo, Autor autor, List<Comentario> comentarios) {
        this.titulo = titulo;
        this.autor = autor;
        this.comentarios = comentarios;
    }

    public Posteo(Long id, String titulo, Autor autor, List<Comentario> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.comentarios = comentarios;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}//Cierre de clase Posteo
