package com.pred.libro.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pred.libro.Objetos.Autores;

@Repository
public interface AutoresRepositorio extends JpaRepository<Autores,String>{

    
}
