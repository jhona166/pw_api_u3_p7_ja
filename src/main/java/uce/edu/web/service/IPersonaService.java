package uce.edu.web.service;

import uce.edu.web.api.repository.modelo.Persona;

public interface IPersonaService {
  public PersonaTo buscarPorId(Integer id);

    public void guardar(PersonaTo persona);

    public void actualizar(PersonaTo persona);

    public void borrar(Integer id);


}
