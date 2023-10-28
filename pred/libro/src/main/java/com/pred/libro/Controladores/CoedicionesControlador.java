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

import com.pred.libro.Objetos.Coediciones;
import com.pred.libro.Servicios.CoedicionesServicio;

@RestController
@ResponseBody
@RequestMapping("/coediciones")
public class CoedicionesControlador {
    
    @Autowired
    CoedicionesServicio coedicionesServicio;
       
    //@PostMapping(path = "/registrarCoediciones",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})    
    //public Coediciones registrarCoediciones(Coediciones institucion){
    @PostMapping("/registrarCoediciones")    
    public Coediciones registrarCoediciones(@RequestBody Coediciones institucion){
        return coedicionesServicio.registrarCoediciones(institucion);
    }

    @CrossOrigin
    //@PutMapping(path = "/modificarCoediciones",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})    
    //public Coediciones modificarCoediciones(@ModelAttribute Coediciones institucion){
    @PutMapping("/modificarCoediciones")    
    public Coediciones modificarCoediciones(@RequestBody Coediciones institucion){
        return coedicionesServicio.modificarCoediciones(institucion);
    }

    @GetMapping("/obtenerCoediciones")
    public List<Coediciones> obtenerCoediciones(){
        return coedicionesServicio.obtenerCoediciones();
    }

    @GetMapping("/obtenerCoedicionesPorId")
    public Optional<Coediciones> obtenerCoedicionesPorId(@RequestParam String institucion){        
        return coedicionesServicio.obtenerCoedicionesPorId(institucion);
    }

    @DeleteMapping("/eliminarCoediciones")
    public void eliminarCoediciones(@RequestParam String institucion){
        coedicionesServicio.eliminarCoediciones(institucion);
    }
    
}
