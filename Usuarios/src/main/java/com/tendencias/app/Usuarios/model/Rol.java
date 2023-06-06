package com.tendencias.app.Usuarios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int id_rol;

    //@Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    //@NotBlank(message = "El usuario no puede estar en blanco")
    @Column(name = "nombre_rol")
    private String nombre_rol;

    //@NotBlank(message = "La clave no puede estar en blanco")
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private int estado;

    @JsonIgnore
    @OneToMany(mappedBy = "rol")
    private List<Usuario> listaUsuario;
}
