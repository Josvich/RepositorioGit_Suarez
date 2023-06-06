package com.tendencias.app.Usuarios.controller;


import com.tendencias.app.Usuarios.model.Rol;
import com.tendencias.app.Usuarios.model.Usuario;
import com.tendencias.app.Usuarios.service.RolServicelmpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    RolServicelmpl rolService;


    @Operation(summary = "Se obtiene la lista de Rol")
    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listaRol() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Rol")
    @PostMapping("/crear")
    public ResponseEntity<Rol> crearUsuario(@RequestBody Rol u) {
        return new ResponseEntity<>(rolService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol u) {
        Rol rol = rolService.findById(id);
        if (rol != null) {
            try {
                rol.setNombre_rol(u.getNombre_rol());
                rol.setDescripcion(u.getDescripcion());
                rol.setEstado(u.getEstado());
                return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> elimiarRol(@PathVariable Integer id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
