package uce.edu.web.api.controler;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;


@Path("/estudiantes")
public class EstudianteController {

    @Inject
    private IEstudianteService iEstudianteService;

    @GET
    @Path("/buscar")
    public EstudianteTo buscarPorId() {
        Integer id = 1;
        return this.iEstudianteService.buscarPorId(id);
    }

    @POST
    @Path("/guardar")
    public void guardar(EstudianteTo estudiante) {
        this.iEstudianteService.guardar(estudiante);
    }

    @PUT
    @Path("/actualizar")
    public void actualizar(EstudianteTo estudiante) {
        this.iEstudianteService.actualizar(estudiante);
    }

    @PATCH
    @Path("/actualizar/parcial")
    public void actualizarParcial(EstudianteTo estudiante) {
        EstudianteTo tmp= this.iEstudianteService.buscarPorId(estudiante.getId());
        tmp.setNombre(estudiante.getNombre());
        this.iEstudianteService.actualizar(tmp);
    }

    @DELETE
    @Path("/borrar")
    public void borrar() {
        Integer id = 2;
        this.iEstudianteService.borrar(id);
    }

    @GET
    @Path("")
    public List<EstudianteTo> buscarTodos(){
        return this.iEstudianteService.buscarTodos();   
     }
    @GET
    @Path("/porNombre")
    public List<EstudianteTo> buscarPorNombre(@QueryParam("nombre") String nombre){
        return this.iEstudianteService.buscarPorNombre(nombre);   
     }
    @GET
    @Path("/porNombreApellido")
    public List<EstudianteTo> buscarPorNombreApellido(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido){
        return this.iEstudianteService.buscarPorNombreApellido(nombre, apellido);
     }
}
