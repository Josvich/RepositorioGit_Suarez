package com.tendencias.app.Usuarios.repository;

import com.tendencias.app.Usuarios.model.Persona;
import com.tendencias.app.Usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    @Query(value = "Select * from persona u where u.nombre_per = :nombre_per", nativeQuery = true)
    public Persona buscarPersona(String nombre);
}
