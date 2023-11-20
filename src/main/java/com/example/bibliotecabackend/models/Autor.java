package com.example.bibliotecabackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
@Table(name = "autores")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_autor;
    private String nombre;
    private Date fecha_nac;
    private String nacionalidad;





}
