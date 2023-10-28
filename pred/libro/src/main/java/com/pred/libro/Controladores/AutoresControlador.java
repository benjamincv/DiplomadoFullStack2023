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

import com.pred.libro.Objetos.Autores;
import com.pred.libro.Servicios.AutoresServicio;

@RestController
@ResponseBody
@RequestMapping("/autores")
public class AutoresControlador {
    
    @Autowired
    AutoresServicio autoresServicio;
        
    //@PostMapping(path = "/registrarAutores",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE}) 
    //public Autores registrarAutores(Autores autores){
    @PostMapping("/registrarAutores") 
    public Autores registrarAutores(@RequestBody Autores autores){
        return autoresServicio.registrarAutores(autores);
    }

    @CrossOrigin
    //@PutMapping(path = "/modificarAutores",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    //public Autores modificarAutores(@ModelAttribute Autores autores){
    @PutMapping("/modificarAutores")
    public Autores modificarAutores(@RequestBody Autores autores){
        return autoresServicio.modificarAutores(autores);
    }

    @GetMapping("/obtenerAutores")
    public List<Autores> obtenerAutores(){
        return autoresServicio.obtenerAutores();
    }

    @GetMapping("/obtenerAutoresPorId")
    public Optional<Autores> obtenerAutoresPorId(@RequestParam String autor){        
        return autoresServicio.obtenerAutoresPorId(autor);
    }

    @DeleteMapping("/eliminarAutores")
    public void eliminarAutores(@RequestParam String autor){
        autoresServicio.eliminarAutores(autor);
    }
    
}
