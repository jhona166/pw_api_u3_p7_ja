package uce.edu.web.api.service;

import uce.edu.web.api.service.to.PersonaTo;

public interface IPersonaService {
    public PersonaTo buscarPorId(Integer id);

    public void guardar(PersonaTo persona);

    public void actualizar(PersonaTo persona);

    public void borrar(Integer id );

}
