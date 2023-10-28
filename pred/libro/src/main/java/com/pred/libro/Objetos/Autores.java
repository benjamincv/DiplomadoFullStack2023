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
@Table(name = "Autores")
public class Autores {

    //CAMPOS DE LAS TABLAS
    @Id
    @Column(name="idAutores",unique = true,nullable = false)
    private String idAutores;

    @Column(name="nombreAutor", unique = false,nullable = false)
    private String nombreAutor;

    @Column(name="gradoAcademico",unique = false, nullable = true)
    private String gradoAcademico;

    @Column(name="institucion",unique = false,nullable = true)
    private String institucion;
    
    //RELACIÓN MUCHOS A MUCHOS ENTRE TABLAS AUTORES Y LIBRO
    //@Column(nullable = true, unique = true)
    @ManyToMany(mappedBy = "autores")
    @JsonIgnore
    Set<Libro> libro;
}

