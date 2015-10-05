package fr.unice.polytech.soa1.beerShop;

import fr.unice.polytech.soa1.beerShop.data.AccountData;
import fr.unice.polytech.soa1.beerShop.data.BeerData;
import fr.unice.polytech.soa1.beerShop.model.Account;
import fr.unice.polytech.soa1.beerShop.model.Beer;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by guillaume on 28/09/2015.
 */
@Path("/public")
@Produces(MediaType.APPLICATION_JSON)
public class PublicService {

    @Path("beers/all")
    @GET
    public Response getAllBeers (){
        //Hardcore logging
        System.out.println("GET /public/beers/all");

        JSONArray result = new JSONArray();
        for(Map.Entry<String, Beer> entry: BeerData.getData().entrySet()) {
            if (entry.getValue().getUser() == null){
                result.put(entry);
            }
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    @Path("beers/{id}")
    @GET
    public Response getABeer (@PathParam("id") String beerName){
        //Hardcore logging
        System.out.println("GET /public/beers/" + beerName);

        JSONArray result = new JSONArray();
        for(Map.Entry<String, Beer> entry: BeerData.getData().entrySet()) {
            if (entry.getValue().getName().equals(beerName)){
                result.put(entry);
            }
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    @Path("account/{username}/{password}")
    @POST
    public Response createAccount(@PathParam("username") String name, @PathParam("password") String password) {

        //Hardcore logging
        System.out.println("POST /account/add/{name}/{password}  --- with name=" + name + ", password=" + password);

        AccountData.add(new Account(name, password));
        return Response.ok().build();
    }

}
