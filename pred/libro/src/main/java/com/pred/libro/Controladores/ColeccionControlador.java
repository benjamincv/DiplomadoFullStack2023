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

import com.pred.libro.Objetos.Coleccion;
import com.pred.libro.Servicios.ColeccionServicio;

@RestController
@ResponseBody
@RequestMapping("/coleccion")
public class ColeccionControlador {
    
    @Autowired
    ColeccionServicio coleccionServicio;

    //@PostMapping(path = "/registrarColeccion",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})        
    //public Coleccion registrarColeccion(Coleccion coleccion){
    @PostMapping("/registrarColeccion")        
    public Coleccion registrarColeccion(@RequestBody Coleccion coleccion){
        return coleccionServicio.registrarColeccion(coleccion);
    }

    @CrossOrigin
    //@PutMapping(path = "/modificarColeccion",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})  
    //public Coleccion modificarColeccion(@ModelAttribute Coleccion coleccion){   
    @PutMapping("/modificarColeccion")  
    public Coleccion modificarColeccion(@RequestBody Coleccion coleccion){   
        return coleccionServicio.modificarColeccion(coleccion);
    }

    @GetMapping("/obtenerColeccion")
    public List<Coleccion> obtenerColeccion(){
        return coleccionServicio.obtenerColeccion();
    }

    @GetMapping("/obtenerColeccionPorId")
    public Optional<Coleccion> obtenerColeccionPorId(@RequestParam String nombre){        
        return coleccionServicio.obtenerColeccionPorId(nombre);
    }

    @DeleteMapping("/eliminarColeccion")
    public void eliminarColeccion(@RequestParam String nombre){
        coleccionServicio.eliminarColeccion(nombre);
    }
    
}
