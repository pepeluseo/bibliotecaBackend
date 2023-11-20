package com.example.bibliotecabackend.models;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
@Table(name = "editoriales")

public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_editorial;
    private String nombre;
    private String direccion;
    private String contacto;


}
