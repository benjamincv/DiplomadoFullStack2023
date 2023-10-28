package com.pred.libro.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pred.libro.Objetos.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial,String>{

}