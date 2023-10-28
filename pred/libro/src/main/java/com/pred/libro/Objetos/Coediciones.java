package com.pred.libro.Objetos;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Coediciones")
public class Coediciones {

    //CAMPOS DE LAS TABLAS
    @Id
    @Column(name="idInstitucion",unique = true,nullable = false)
    private String idInstitucion;

    @Column(name="nombreInst", unique = false,nullable = false)
    private String nombreInst;

    @Column(name="siglasInst",unique = false, nullable = false)
    private String siglasInst;  

    //RELACIÓN MUCHOS A MUCHOS ENTRE TABLAS AUTORES Y LIBRO
    //@Column(nullable = true, unique = true)
    @ManyToMany(mappedBy = "coediciones")
    @JsonIgnore
    Set<Libro>libro;
}
