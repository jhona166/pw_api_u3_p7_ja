package uce.edu.web.api.service;

import java.util.List;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IPersonaRepository;
import uce.edu.web.api.repository.modelo.Persona;
import uce.edu.web.api.service.to.PersonaTo;


@ApplicationScoped
public class PersonaServiceImpl implements IPersonaService{

    @Inject
    private IPersonaRepository iPersonaRepository;

    private Function<Persona, PersonaTo> mapTo = p ->{
        PersonaTo  pTo= new PersonaTo(p.getId(),p.getNombre(),p.getApellido(),p.getFechaNacimiento());
        return pTo;
    };

    private Function<PersonaTo,Persona> mapPersona = pTo->{
        Persona p = new Persona(pTo.getId(),pTo.getNombre(),pTo.getApellido(),pTo.getFechaNacimiento());
        return p;
    };

    @Override
    public PersonaTo buscarPorId(Integer id) {
        Persona per = this.iPersonaRepository.buscarPorId(id);
        return this.mapTo.apply(per);
    }

    @Override
    public void guardar(PersonaTo persona) {
        this.iPersonaRepository.insertar(this.mapPersona.apply(persona));
    }

    @Override
    public void actualizar(PersonaTo persona) {
        Persona per = this.mapPersona.apply(persona);
        this.iPersonaRepository.actualizar(per);
    }

    @Override
    public void borrar(Integer id) {
        this.iPersonaRepository.eliminar(id);
    }

    @Override
    public List<PersonaTo> buscarTodos() {
        List<Persona> personas = this.iPersonaRepository.buscarTodos();
        return personas.stream().map(this.mapTo).toList();
    }

    @Override
    public List<PersonaTo> buscarPorNombre(String nombre) {
        try {
            List<Persona> personas = this.iPersonaRepository.buscarPorNombre(nombre);
            return personas.stream().map(this.mapTo).toList();
        } catch (Exception e) {
           
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<PersonaTo> buscarPorNombreApellido(String nombre, String apellido) {
        List<Persona> personas = this.iPersonaRepository.buscarPorNombreApellido(nombre, apellido);
        return personas.stream().map(this.mapTo).toList();
    }


    
}
