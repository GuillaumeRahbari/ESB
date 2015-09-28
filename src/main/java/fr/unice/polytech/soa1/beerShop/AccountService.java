package fr.unice.polytech.soa1.beerShop;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by guillaume on 28/09/2015.
 */
@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountService {

    private Map<String,String> users = new HashMap<String, String>(){{
        this.put("GuiGui","I<3Penises");
        this.put("Tom", "I<3GuiGui");
    }
    };

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewAccount(String name, String password) {
        return Response.ok().build();
    }

    @Path("/{name}/{password}")
    @GET
    public Response getAccount(@PathParam("name") String name, @PathParam("password") String password) {
        if (users.containsKey(name)){
            if (users.get(name).equals(password)){
                return Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
