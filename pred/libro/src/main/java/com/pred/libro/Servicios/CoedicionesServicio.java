package com.pred.libro.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pred.libro.Objetos.Coediciones;
import com.pred.libro.Repositorios.CoedicionesRepositorio;

//import jakarta.transaction.Transactional;

@Service
public class CoedicionesServicio {
       
    @Autowired
    CoedicionesRepositorio coedicionesRepositorio;

    Coediciones coedicionesP = new Coediciones();

    public Coediciones registrarCoediciones(Coediciones institucion){
        if(coedicionesRepositorio.existsById(institucion.getIdInstitucion())){       
            return coedicionesP;
        }else{
            return coedicionesRepositorio.save(institucion);
            
        }
    }

    public Coediciones modificarCoediciones(Coediciones institucion){
        if(coedicionesRepositorio.existsById(institucion.getIdInstitucion())){
            return coedicionesRepositorio.save(institucion);
        }else{
            return coedicionesP;
        }
    }

    public List<Coediciones> obtenerCoediciones(){
        return coedicionesRepositorio.findAll();
    }

    public Optional<Coediciones> obtenerCoedicionesPorId(String institucion){
        return coedicionesRepositorio.findById(institucion);        
    }

    //@Transactional
    public void eliminarCoediciones(String institucion){
        coedicionesRepositorio.deleteById(institucion);        
    }
}