package fr.unice.polytech.soa1.beerShop;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.soa1.beerShop.data.BeerData;
import fr.unice.polytech.soa1.beerShop.model.Beer;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by tom on 28/09/15.
 */

@Path("/beers")
@Produces(MediaType.APPLICATION_JSON)
public class BeersService {

    @GET
    @Path("/all")
    public Response getAllBeers (@DefaultValue("") @QueryParam("username") String username){
        //Hardcore logging
        System.out.println("GET /beers/all");

        JSONArray result = new JSONArray();
        for(Map.Entry<String, Beer> entry: BeerData.getData().entrySet()) {
            if (entry.getValue().getUser() == null || entry.getValue().getUser().equals(username)){
                result.put(entry);
            }
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    @Path("/{id}")
    @GET
    public Response getBeer (@PathParam("id") String beerName, @DefaultValue("") @QueryParam("username") String username){
        //Hardcore logging
        System.out.println("GET /beers/" + beerName + "?username=" + username);

        JSONArray result = new JSONArray();
        for(Map.Entry<String, Beer> entry: BeerData.getData().entrySet()) {
            if (entry.getValue().getUser().equals(username) && entry.getValue().getName().equals(beerName)){
                result.put(entry);
            }
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    @POST
    @Path("/new")
    public Response createBeer(@PathParam("name") String beerName){
        ObjectMapper mapper = new ObjectMapper();
        //Hardcore logging
        System.out.println("POST /beers/new --- with " + beerName);
        try {
            Beer beer = mapper.readValue(beerName,Beer.class);
            BeerData.add(beer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBeer (@PathParam("id") String beerName, @QueryParam("username") String username){
        //Hardcore logging
        System.out.println("DELETE /beers/" + beerName + "?username=" + username);

        for(Map.Entry<String, Beer> entry: BeerData.getData().entrySet()) {
            if (entry.getValue().getUser().equals(username) && entry.getValue().getName().equals(beerName)){
                BeerData.delete(entry.getValue());
            }
        }
        return  Response.ok().build();
    }

}
