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

import com.pred.libro.Objetos.Editorial;
import com.pred.libro.Servicios.EditorialServicio;

@RestController
@ResponseBody
@RequestMapping("/editorial")
public class EditorialControlador {
    
    @Autowired
    EditorialServicio editorialServicio;
       
    //@PostMapping(path = "/registrarEditorial",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})    
    //public Editorial registrarEditorial(Editorial editorial){
    @PostMapping("/registrarEditorial")    
    public Editorial registrarEditorial(@RequestBody Editorial editorial){
        return editorialServicio.registrarEditorial(editorial);
    }

    @CrossOrigin
    //@PutMapping(path = "/modificarEditorial",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})    
    //public Editorial modificarEditorial(@ModelAttribute Editorial editorial){
    @PutMapping("/modificarEditorial")    
    public Editorial modificarEditorial(@RequestBody Editorial editorial){
        return editorialServicio.modificarEditorial(editorial);
    }

    @GetMapping("/obtenerEditorial")
    public List<Editorial> obtenerEditorial(){
        return editorialServicio.obtenerEditorial();
    }

    @GetMapping("/obtenerEditorialPorId")
    public Optional<Editorial> obtenerEditorialPorId(@RequestParam String editorial){        
        return editorialServicio.obtenerEditorialPorId(editorial);
    }

    @DeleteMapping("/eliminarEditorial")
    public void eliminarEditorial(@RequestParam String editorial){
        editorialServicio.eliminarEditorial(editorial);
    }
    
}
