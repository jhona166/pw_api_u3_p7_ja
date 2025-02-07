package uce.edu.web.api.service;

import java.util.List;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService{

    @Inject
    private IEstudianteRepository iEstudianteRepository;

    private Function<Estudiante,EstudianteTo> mapTo = e->{
        EstudianteTo eTo = new EstudianteTo(e.getId(),e.getNombre(),e.getApellido(),e.getFechaNacimiento(),e.getGenero());
        return eTo;
    };

    private Function<EstudianteTo,Estudiante> mapEstudiante = eTo->{
        Estudiante e =new Estudiante(eTo.getId(),eTo.getNombre(),eTo.getApellido(),eTo.getFechaNacimiento(),eTo.getGenero());
        return e;
    };


    @Override
    public EstudianteTo buscarPorId(Integer id) {
        Estudiante est = this.iEstudianteRepository.buscarPorId(id);
        return this.mapTo.apply(est);
    
    }

    @Override
    public void guardar(EstudianteTo estudiante) {
        this.iEstudianteRepository.insertar(this.mapEstudiante.apply(estudiante));
    }

    @Override
    public void actualizar(EstudianteTo estudiante) {
        Estudiante est  = this.mapEstudiante.apply(estudiante);
        this.iEstudianteRepository.actualizar(est);
    }

    @Override
    public void borrar(Integer id) {
        this.iEstudianteRepository.eliminar(id);
    }

    @Override
    public List<EstudianteTo> buscarTodos() {
        List<Estudiante> estudiantes = this.iEstudianteRepository.buscarTodos();
        return estudiantes.stream().map(this.mapTo).toList();
    }
 
    @Override
    public List<EstudianteTo> buscarPorNombre(String nombre) {
        List<Estudiante> estudiantes = this.iEstudianteRepository.buscarPorNombre(nombre);
        return estudiantes.stream().map(this.mapTo).toList();
    }
    @Override
    public List<EstudianteTo> buscarPorNombreApellido(String nombre, String apellido) {
        List<Estudiante> estudiantes = this.iEstudianteRepository.buscarPorNombreApellido(nombre, apellido);
        return estudiantes.stream().map(this.mapTo).toList();
    }
    
}
