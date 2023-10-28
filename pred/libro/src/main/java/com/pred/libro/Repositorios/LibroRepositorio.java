package com.pred.libro.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pred.libro.Objetos.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,String>{

    
}