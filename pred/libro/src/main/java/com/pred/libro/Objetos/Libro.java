package com.pred.libro.Objetos;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Libro")

public class Libro {

    //CAMPOS DE LAS TABLAS
    @Id
    @Column(name="idregistro",unique = true,nullable = false)
    private String idregistro;

    @Column(name="titulo", unique = false,nullable = false)
    private String titulo;

    @Column(name="subtitulo",unique = false, nullable = true)
    private String subtitulo;

    @Column(name="isbn",unique = false,nullable = true)
    private String isbn;
    

    //RELACIÓN MUCHOS A MUCHOS ENTRE TABLAS AUTORES Y LIBRO
    @Column(name="autores", nullable=true)
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "Libro_has_Autores", joinColumns = @JoinColumn(name="Libro_idregistro"),
    inverseJoinColumns = @JoinColumn(name = "Autores_idAutores"))
    Set<Autores>autores;

    //RELACIÓN MUCHOS A MUCHOS ENTRE TABLAS COEDICIONES Y LIBRO
    @Column(name="coediciones", nullable=true)
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "Libro_has_Coediciones", joinColumns = @JoinColumn(name="Libro_idregistro"),
    inverseJoinColumns = @JoinColumn(name = "Coediciones_idInstitucion"))
    Set<Coediciones>coediciones; 
 
    //RELACIÓN MUCHOS A UNO ENTRE TABLAS EDITORIAL Y LIBRO
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "Editorial_idEditorial", referencedColumnName = "idEditorial",  nullable=false)
    private Editorial editorial;

    //RELACIÓN UNO A UNO ENTRE TABLAS COLECCION Y LIBRO
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Coleccion_idColeccion", referencedColumnName = "idColeccion", nullable = false)
    private Coleccion coleccion;
}
