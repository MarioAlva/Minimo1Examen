package edu.upc.dsa.services;

import edu.upc.dsa.UserManager;
import edu.upc.dsa.UserManagerImpl;
import edu.upc.dsa.models.User;
import edu.upc.dsa.util.RandomUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/products", description = "Endpoint to Product Service")
@Path("/products")
public class UsersService {

    private UserManager um;

    public UsersService() {
        this.um = UserManagerImpl.getInstance();
        if (um.size()==0) {
            this.um.Registro("oiram99", "Mario", "Alva Howes", "mario@test.com", "test");
            this.um.Registro("pepe99", "Pepe", "Gonzalez Rodriguez", "pepe@test.com", "test");
            this.um.Registro("juan99", "Juan", "Baco Jimenez", "juan@test.com", "test");
            this.um.Registro("nadia99", "Nadia", "Bacarro tello", "nadia@test.com", "test");
            this.um.Registro("repetido", "Nadia", "Alva Howes", "testrepeticion@test.com", "test");
        }


    }

    @Path("/users")
    @GET
    @ApiOperation(value = "get all products sorted", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = String.class, responseContainer="List"),
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsSorted() {

        List<User> users = this.um.usuariosregistadosordenador();
        List<String> usersS = new ArrayList<String>();
        usersS.add("aaaa");


        //GenericEntity<List<User>> entity = new GenericEntity<List<User>>(users) {};
        GenericEntity<List<String>> entity = new GenericEntity<List<String>>(usersS) {};
        return Response.status(201).entity(entity).build()  ;

    }

    /*@GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Product t = this.pm.get(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.pm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.pm.deleteTrack(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.pm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }


    @POST
    @ApiOperation(value = "create a new order", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Order.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/orders")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newOrder(OrderTO order) {
        System.out.println(order.getId() + " " + order.getListap());
        if (order.getListap()==null || order.getId()==null)  return Response.status(500).entity(order).build();
        this.pm.addOrder(order, RandomUtils.getId());
        return Response.status(201).entity(order).build();
    }*/
}
