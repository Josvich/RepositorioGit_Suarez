package com.tendencias.app.Usuarios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id_persona;

    //@Size(min = 3, max = 10, message = "El nombre debe tener entre 3 y 10 caracteres")
    //@NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre_per")
    private String nombre_per;

    //@Size(min = 3, max = 10, message = "El apellido debe tener entre 3 y 10 caracteres")
    //@NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido_per")
    private String apellido_per;

    //@Email(message = "Debe ingresar una dirección de correo válida")
    @Column(name = "correo")
    private String correo;

    //@NotBlank(message = "La cedula no puede estar en blanco")
    @Column(name = "cedula")
    private String cedula;

    //@NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(name = "instruccion")
    private String instruccion;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> listaUsuario;

}
