package com.pred.libro.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pred.libro.Objetos.Coleccion;
import com.pred.libro.Repositorios.ColeccionRepositorio;

//import jakarta.transaction.Transactional;

@Service
public class ColeccionServicio {
       
    @Autowired
    ColeccionRepositorio coleccionRepositorio;

    Coleccion coleccionP = new Coleccion();

    public Coleccion registrarColeccion(Coleccion coleccion){
        if(coleccionRepositorio.existsById(coleccion.getIdColeccion())){       
            return coleccionP;
        }else{
            return coleccionRepositorio.save(coleccion);
            
        }
    }

    public Coleccion modificarColeccion(Coleccion coleccion){
        if(coleccionRepositorio.existsById(coleccion.getIdColeccion())){
            return coleccionRepositorio.save(coleccion);
        }else{
            return coleccionP;
        }
    }

    public List<Coleccion> obtenerColeccion(){
        return coleccionRepositorio.findAll();
    }

    public Optional<Coleccion> obtenerColeccionPorId(String nombre){
        return coleccionRepositorio.findById(nombre);        
    }

    //@Transactional
    public void eliminarColeccion(String nombre){
        coleccionRepositorio.deleteById(nombre);        
    }
}