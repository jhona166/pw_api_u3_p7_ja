package uce.edu.web.api.controler;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;


@Path("/personas")
public class PersonaController {
    
 @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/{id}")
    //public Response buscarPorId(@PathParam("id") Integer id ) {
    public PersonaTo buscarPorId(@PathParam("id") Integer id) {
       // Integer id=1;
       return this.iPersonaService.buscarPorId(id);
       //return Response.ok(this.iPersonaService.buscarPorId(id)).build();
    }
    @POST
    @Path("")
    //http://localhost:8080/matriculaAPI/v1.1/personas/guardar
    public void guardar(PersonaTo persona) {
        this.iPersonaService.guardar(persona);
    }
    @PUT
    @Path("/{id}")
    public void actualizar(PersonaTo persona,@PathParam("id") Integer id ) {
        persona.setId(id);
        this.iPersonaService.actualizar(persona);
    }

    @DELETE
    @Path("/{id}")
    public void borrar(PersonaTo persona,@PathParam("id") Integer id) {
       
        this.iPersonaService.borrar(id);
    }
    //Poner anotacion a los objetods que van a viajar en el request 

    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(PersonaTo persona,@PathParam("id") Integer id,@PathParam("cedula") String cedula) {
        System.err.println(cedula);
        PersonaTo tmp =this.iPersonaService.buscarPorId(persona.getId());
        tmp.setNombre(persona.getNombre());
        this.iPersonaService.actualizar(tmp);

        
    }

}
