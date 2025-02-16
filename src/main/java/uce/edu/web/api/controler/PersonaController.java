package uce.edu.web.api.controler;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;


@Path("/personas")
public class PersonaController {
    
    @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer id ) {
    //public PersonaTo buscarPorId(@PathParam("id") Integer id) {
       // Integer id=1;
      // return this.iPersonaService.buscarPorId(id);
       //return Response.ok(this.iPersonaService.buscarPorId(id)).build();
       return Response.status(240).header("mensaje","Persona creada pero en proceso de validacion .......").header("valor1",500)
                        .entity(this.iPersonaService.buscarPorId(id)).build();
      //.header("valor1",500)
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
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
    public void borrar(@PathParam("id") Integer id) {
       
        this.iPersonaService.borrar(id);
    }
    //Poner anotacion a los objetods que van a viajar en el request 


    //actualizacion parcial
    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonaTo actualizarParcial(PersonaTo persona,@PathParam("id") Integer id,@PathParam("cedula") String cedula) {
        
        System.out.println(cedula);
        PersonaTo tmp =this.iPersonaService.buscarPorId(id);
        tmp.setNombre(persona.getNombre());
        this.iPersonaService.actualizar(tmp);
        return tmp;
        
    }

/* 
    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(PersonaTo persona,@PathParam("id") Integer id,@PathParam("cedula") String cedula) {
        System.out.println(cedula);
        PersonaTo tmp =this.iPersonaService.buscarPorId(id);
        tmp.setNombre(persona.getNombre());
        this.iPersonaService.actualizar(tmp);

        
    }*/

    @GET
    @Path("")
    public List<PersonaTo> buscarTodos() {
      return this.iPersonaService.buscarTodos();
    }

    //solo ? cuando chocan los path
    @GET
    @Path("/porNombre")
    public List<PersonaTo> buscarPorNombre(@QueryParam("nombre") String nombre) {
       
        return this.iPersonaService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/porNombreApellido")
    public List<PersonaTo> buscarPorNombre(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
       
        return this.iPersonaService.buscarPorNombreApellido(nombre,apellido);
    }



}
