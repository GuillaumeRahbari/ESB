package fr.unice.polytech.soa1.beerShop;

import fr.unice.polytech.soa1.beerShop.data.AccountData;
import fr.unice.polytech.soa1.beerShop.model.Account;

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


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewAccount(String name, String password) {

        //Hardcore logging
        System.out.println("POST /account/#smthg");

        return Response.ok().build();
    }



    @Path("/{name}/{password}")
    @GET
    public Response getAccount(@PathParam("name") String name, @PathParam("password") String password) {

        //Hardcore logging
        System.out.println("GET /account/{name}/{password} --- with name=" + name + ", password=" + password);


        //Map<String,Account> users = AccountData.getData();
        if (AccountData.get(name)!=null){
            if (AccountData.get(name).getPassword().equals(password)){
                System.out.println("Logged");
                return Response.ok().build();
            }
        }
        System.out.println("Not Logged");
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/add/{name}/{password}")
    public Response createAccount(@PathParam("name") String username, @PathParam("password") String password){

        //Hardcore logging
        System.out.println("GET /account/add/{name}/{password}  --- with name=" + username + ", password=" + password);

        AccountData.add(new Account(username, password));

        return  Response.ok().build();

    }

}
