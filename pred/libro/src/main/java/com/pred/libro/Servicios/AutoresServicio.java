package com.pred.libro.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pred.libro.Objetos.Autores;
import com.pred.libro.Repositorios.AutoresRepositorio;

//import jakarta.transaction.Transactional;

@Service
public class AutoresServicio {
       
    @Autowired
    AutoresRepositorio autoresRepositorio;

    Autores autoresP = new Autores();

    public Autores registrarAutores(Autores autores){
        if(autoresRepositorio.existsById(autores.getIdAutores())){       
            return autoresP;
        }else{
            return autoresRepositorio.save(autores);
            
        }
    }

    public Autores modificarAutores(Autores autores){
        if(autoresRepositorio.existsById(autores.getIdAutores())){
            return autoresRepositorio.save(autores);
        }else{
            return autoresP;
        }
    }

    public List<Autores> obtenerAutores(){
        return autoresRepositorio.findAll();
    }

    public Optional<Autores> obtenerAutoresPorId(String autor){
        return autoresRepositorio.findById(autor);        
    }

    //@Transactional
    public void eliminarAutores(String autor){
        autoresRepositorio.deleteById(autor);        
    }
}