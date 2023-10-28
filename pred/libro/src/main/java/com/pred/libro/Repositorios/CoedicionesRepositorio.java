package com.pred.libro.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pred.libro.Objetos.Coediciones;

@Repository
public interface CoedicionesRepositorio extends JpaRepository<Coediciones,String>{

    
}