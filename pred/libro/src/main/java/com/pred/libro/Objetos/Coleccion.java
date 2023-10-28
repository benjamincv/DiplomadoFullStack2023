package com.pred.libro.Objetos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Coleccion")
public class Coleccion {

    //CAMPOS DE LAS TABLAS
    @Id
    @Column(name="idColeccion",unique = true,nullable = false)
    private String idColeccion;

    @Column(name="nombreCol", unique = false,nullable = false)
    private String nombreCol;

    @Column(name="ancho",unique = false, nullable = false)
    private String ancho;

     @Column(name="alto",unique = false,nullable = false)
    private String alto;
    
    //RELACIÓN UNO A UNO ENTRE TABLAS COLECCION Y LIBRO
    @OneToOne(mappedBy ="coleccion")
    @JsonIgnore
    private Libro libro;
}
