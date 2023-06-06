package com.tendencias.app.Usuarios.repository;

import com.tendencias.app.Usuarios.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    @Query(value = "Select * from rol u where u.nombre_rol = :nombre_rol", nativeQuery = true )
    public Rol buscarRol(String nombre);
}
