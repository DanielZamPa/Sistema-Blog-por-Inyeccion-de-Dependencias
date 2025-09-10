package com.Sistema_basico_Blog.miBlog.repository;

import com.Sistema_basico_Blog.miBlog.modelo.Posteo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PosteoRepository implements IposteoRepository{
    private List<Posteo> posts = new ArrayList<>();

    public PosteoRepository() {
        posts.add(new Posteo(1L, "Daniel", "Mis experiencias como desarrollador"));
        posts.add(new Posteo(2L, "Andres", "Mi incursion en la IA"));
        posts.add(new Posteo(3L, "Valeria", "Mi vida como programadora"));
    }

    @Override
    public List<Posteo> findAll() {
        return posts;
    }

    @Override
    public Posteo findById(Long id) {
        for (Posteo post: posts){
            if (post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }

    @Override
    public void save(Posteo posteo) {
        posts.add(posteo);
    }
}
