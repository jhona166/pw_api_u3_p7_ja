package uce.edu.web.api.repository.modelo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Persona;
 
@Transactional
@ApplicationScoped // En lugar del Repository aqui se usa esta
public class PersonaRepositoryImpl implements IPersonaRepository {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    @Override
    public Persona buscarPorId(Integer id) {
        return this.entityManager.find(Persona.class, id);
       
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
 
}