package fr.unice.polytech.soa1.beerShop;

import fr.unice.polytech.soa1.beerShop.data.BeerData;
import fr.unice.polytech.soa1.beerShop.model.Beer;
import org.json.JSONArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by tom on 28/09/15.
 */

@Path("/beers")
@Produces(MediaType.APPLICATION_JSON)
public class BeerService {

    @GET
    @Path("/all")
    public Response getAllBeers() {

        //Hardcore logging
        System.out.println("GET /beers/all");

        JSONArray result = new JSONArray();
        for(Map.Entry<String, Beer> entry: BeerData.getData().entrySet()) {
            result.put(entry);
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    @GET
    @Path("/add/{name}")
    public Response addBeer(@PathParam("name") String beerName){

        //Hardcore logging
        System.out.println("GET /beers/add/{name} --- with name=" + beerName + "");

        BeerData.add(new Beer(beerName));

        return  Response.ok().build();

    }

}
