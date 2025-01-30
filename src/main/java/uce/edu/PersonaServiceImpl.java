package uce.edu;

import io.quarkus.tls.runtime.config.PemCertsConfig;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IPersonaRepository;
import uce.edu.web.api.repository.modelo.Persona;
import uce.edu.web.service.IPersonaService;
import uce.edu.web.service.PersonaService;
import uce.edu.web.service.PersonaTo;


@AplicationScoped
public class PersonaServiceImpl  implements IPersonaService{

private Function<Persona,PersonaTo> mapTo = p -> {
    PersonaTo pTo = new PersonaTo(p.getId(),p.getNombre(),p.getApellido(),p.getFechaNacimiento());
    return pTo;
}

private Function<PersonaTo,Persona> mapPersona = pto -> {
    Persona p = new PersonaTo(p.getId(),p.getNombre(),p.getApellido(),p.getFechaNacimiento());
    return p;
}

    @Inject
    private IPersonaRepository iPersonaRepository;

    @Override
    public PersonaTo buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public void guardar(PersonaTo persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public void actualizar(PersonaTo persona) {
      Persona per = this.mapTo.apply(persona);
      this.iPersonaRepository.actualiza();
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrar'");
    }
    

}
