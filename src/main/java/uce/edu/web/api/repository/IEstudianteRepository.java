package uce.edu.web.api.repository;

import uce.edu.web.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {

        public Estudiante buscarPorId(Integer id);
        public void insertar(Estudiante estudiante);
        public void actualizar(Estudiante estudiante);
        public void eliminar(Integer id);

        
}
