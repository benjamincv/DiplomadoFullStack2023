package com.pred.libro.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pred.libro.Objetos.Libro;
import com.pred.libro.Repositorios.LibroRepositorio;

//import jakarta.transaction.Transactional;

@Service
public class LibroServicio {
       
    @Autowired
    LibroRepositorio libroRepositorio;

    Libro libroP = new Libro();

    public Libro registrarLibro(Libro libro){
        if(libroRepositorio.existsById(libro.getIdregistro())){       
            return libroP;
        }else{
            return libroRepositorio.save(libro);
            
        }
    }

    public Libro modificarLibro(Libro libro){
        if(libroRepositorio.existsById(libro.getIdregistro())){
            return libroRepositorio.save(libro);
        }else{
            return libroP;
        }
    }

    public List<Libro> obtenerLibro(){
        return libroRepositorio.findAll();
    }

    public Optional<Libro> obtenerLibroPorId(String registro){
        return libroRepositorio.findById(registro);        
    }
    
    //@Transactional
    public void eliminarLibro(String registro){
        libroRepositorio.deleteById(registro);        
    }
}