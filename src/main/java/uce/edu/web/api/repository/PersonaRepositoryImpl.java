package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Persona;


@Transactional
@ApplicationScoped
public class PersonaRepositoryImpl implements IPersonaRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Persona buscarPorId(Integer id) {
        return this.entityManager.find(Persona.class,id);


    }

    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);

    }

    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscarPorId(id));
    }

    @Override
    public List<Persona> buscarTodos() {
       TypedQuery<Persona> myQuery  =  this.entityManager.createQuery("select p from Persona p",Persona.class);
       return  myQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombre(String nombre) {
        TypedQuery<Persona> myQuery  =  this.entityManager.createQuery("select p from Persona p where p.nombre=:nombre",Persona.class);
        myQuery.setParameter("nombre", nombre);
        try {
            return myQuery.getResultList();
        } catch (Exception e) {
           
            System.err.println("Error " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
        TypedQuery<Persona> myQuery = this.entityManager.createQuery("select p from Persona p where p.nombre=:nombre and p.apellido=:apellido", Persona.class);
        myQuery.setParameter("nombre", nombre);
        myQuery.setParameter("apellido", apellido);
        return myQuery.getResultList();
    }


    
}
