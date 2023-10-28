package com.pred.libro.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pred.libro.Objetos.Coleccion;

@Repository
public interface ColeccionRepositorio extends JpaRepository<Coleccion,String>{

    
}
