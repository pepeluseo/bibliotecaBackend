package com.example.bibliotecabackend.models;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_libro;
    private String titulo;
    private int autor;
    private String portada;
    private String anyo;
    private Long isbn;
    private int editorial;
    private int genero;

}
