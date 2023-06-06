package com.tendencias.app.Usuarios.service;

import com.tendencias.app.Usuarios.model.Persona;
import com.tendencias.app.Usuarios.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicelmpl extends GenericServiceImpl<Persona, Integer> implements GenericService<Persona, Integer>{
    @Autowired
    PersonaRepository personaRepository;


    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return personaRepository;
    }
}
