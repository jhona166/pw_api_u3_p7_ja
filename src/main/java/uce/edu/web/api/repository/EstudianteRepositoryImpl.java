package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Estudiante;

@Transactional
@ApplicationScoped
public class EstudianteRepositoryImpl implements IEstudianteRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante buscarPorId(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscarPorId(id));
    }

     @Override
    public List<Estudiante> buscarTodos() {
        TypedQuery<Estudiante> myQuery =this.entityManager.createQuery("SELECT e from Estudiante e", Estudiante.class);
        return myQuery.getResultList();
    }
    @Override
    public List<Estudiante> buscarPorNombre(String nombre) {
        TypedQuery<Estudiante> myQuery =this.entityManager.createQuery("SELECT e from Estudiante e WHERE e.nombre =:nombre", Estudiante.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();
    }
    @Override
    public List<Estudiante> buscarPorNombreApellido(String nombre, String apellido) {
        TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("SELECT e from Estudiante e WHERE e.nombre =:nombre AND e.apellido =:apellido", Estudiante.class);
        myQuery.setParameter("nombre", nombre);
        myQuery.setParameter("apellido", apellido);
        return myQuery.getResultList();
    }
    
}
