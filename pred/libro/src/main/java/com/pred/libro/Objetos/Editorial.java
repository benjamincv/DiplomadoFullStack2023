package com.pred.libro.Objetos;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Editorial")
public class Editorial {

    //CAMPOS DE LAS TABLAS
    @Id
    @Column(name="idEditorial",unique = true,nullable = false)
    private String idEditorial;

    @Column(name="nombre", unique = false,nullable = false)
    private String nombre;

    @Column(name="direccion",unique = false, nullable = false)
    private String direccion;

    @Column(name="telefono",unique = false,nullable = false)
    private String telefono;
    
    @OneToMany(mappedBy = "editorial")
    @JsonIgnore
    private Set<Libro> libro;
}