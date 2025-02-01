package uce.edu.web.api.controler;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;


@Path("/personas")
public class PersonaController {
    
 @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/buscar")
    //public Response buscarPorId( ) {
    public PersonaTo buscarPorId() {
        Integer id=1;
        return this.iPersonaService.buscarPorId(id);
       // return Response.ok(this.iPersonaService.buscarPorId(id)).build();
    }
    @POST
    @Path("/guardar")
    //http://localhost:8080/matriculaAPI/v1.1/personas/guardar
    public void guardar(PersonaTo persona) {
        this.iPersonaService.guardar(persona);
    }
    @PUT
    @Path("/actualizar")
    public void actualizar(PersonaTo persona) {
        this.iPersonaService.actualizar(persona);
    }

    @DELETE
    @Path("/borrar")
    public void borrar() {
        Integer id = 1;
        this.iPersonaService.borrar(id);
    }
    //Poner anotacion a los objetods que van a viajar en el request 

    @PATCH
    @Path("/actualizar/parcial")
    public void actualizarParcial(PersonaTo persona) {
        PersonaTo tmp =this.iPersonaService.buscarPorId(persona.getId());
        tmp.setNombre(persona.getNombre());
        this.iPersonaService.actualizar(persona);
    }

}
