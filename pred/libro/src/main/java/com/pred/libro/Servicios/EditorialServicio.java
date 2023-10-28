package com.pred.libro.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pred.libro.Objetos.Editorial;
import com.pred.libro.Repositorios.EditorialRepositorio;

//import jakarta.transaction.Transactional;

@Service
public class EditorialServicio {
       
    @Autowired
    EditorialRepositorio editorialRepositorio;

    Editorial editorialP = new Editorial();

    public Editorial registrarEditorial(Editorial editorial){
        if(editorialRepositorio.existsById(editorial.getIdEditorial())){       
            return editorialP;
        }else{
            return editorialRepositorio.save(editorial);
            
        }
    }

    public Editorial modificarEditorial(Editorial editorial){
        if(editorialRepositorio.existsById(editorial.getIdEditorial())){            
            return editorialRepositorio.save(editorial);
        }else{
            return editorialP;
        }
    }

    public List<Editorial> obtenerEditorial(){
        return editorialRepositorio.findAll();
    }

    public Optional<Editorial> obtenerEditorialPorId(String editorial){
        return editorialRepositorio.findById(editorial);        
    }

    //@Transactional
    public void eliminarEditorial(String editorial){
        editorialRepositorio.deleteById(editorial);        
    }
}