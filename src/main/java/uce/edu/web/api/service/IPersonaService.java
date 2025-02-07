package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.service.to.PersonaTo;

public interface IPersonaService {
    public PersonaTo buscarPorId(Integer id);

    public void guardar(PersonaTo persona);

    public void actualizar(PersonaTo persona);

    public void borrar(Integer id );

 public List<PersonaTo> buscarPorNombreApellido(String nombre, String apellido);

     public List<PersonaTo>  buscarTodos();

    public List<PersonaTo> buscarPorNombre(String nombre);

}
