package com.Sistema_basico_Blog.miBlog.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne
    @JsonBackReference("comentarios")
    private Autor createdAt;

    @ManyToOne
    @JsonBackReference("comentariosPost")
    private Posteo post;

    public Comentario() {}

    public Comentario(String text, Autor createdAt, Posteo post) {
        this.text = text;
        this.createdAt = createdAt;
        this.post = post;
    }

    public Comentario(Long id, String text, Autor createdAt, Posteo post) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Autor getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Autor createdAt) {
        this.createdAt = createdAt;
    }

    public Posteo getPost() {
        return post;
    }

    public void setPost(Posteo post) {
        this.post = post;
    }
}//Cierre de clase comentario
