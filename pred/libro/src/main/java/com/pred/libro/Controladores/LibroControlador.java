package com.pred.libro.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pred.libro.Objetos.Libro;
import com.pred.libro.Servicios.LibroServicio;

@RestController
@ResponseBody
@RequestMapping("/libro")
public class LibroControlador {
    
    @Autowired
    LibroServicio libroServicio;
    
    //@PostMapping(path = "/registrarLibro",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})  
    //public Libro registrarAutores(Libro libro){    
    @PostMapping("/registrarLibro")  
    public Libro registrarAutores(@RequestBody Libro libro){        
        return libroServicio.registrarLibro(libro);
    }

    @CrossOrigin
    //@PutMapping(path = "/modificarLibro",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})     
    //public Libro modificarLibro(@ModelAttribute Libro libro){
    @PutMapping("/modificarLibro")     
    public Libro modificarLibro(@RequestBody Libro libro){
        return libroServicio.modificarLibro(libro);
    }

    @GetMapping("/obtenerLibro")
    public List<Libro> obtenerLibro(){
        return libroServicio.obtenerLibro();
    }

    @GetMapping("/obtenerLibroPorId")
    public Optional<Libro> obtenerLibroPorId(@RequestParam String registro){        
        return libroServicio.obtenerLibroPorId(registro);
    }

    @DeleteMapping("/eliminarLibro")
    public void eliminarLibro(@RequestParam String registro){
        libroServicio.eliminarLibro(registro);
    }
    
}