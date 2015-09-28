package fr.unice.polytech.soa1.beerShop;

import org.json.JSONArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tom on 28/09/15.
 */

@Path("/beers")
@Produces(MediaType.APPLICATION_JSON)
public class BeerService {

    @GET
    public Response getAvailableGenerators() {
        Collection<String> gens = new ArrayList<String>(){
            {
            this.add("Leffe");
            this.add("Rebook");
            }
        };
        JSONArray result = new JSONArray();
        for(String g: gens) {
            result.put(g);
        }
        return Response.ok().entity(result.toString(2)).build();
    }

}
