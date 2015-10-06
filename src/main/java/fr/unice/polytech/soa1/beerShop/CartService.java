package fr.unice.polytech.soa1.beerShop;

import fr.unice.polytech.soa1.beerShop.data.BeerData;
import fr.unice.polytech.soa1.beerShop.data.CartData;
import fr.unice.polytech.soa1.beerShop.model.Beer;
import fr.unice.polytech.soa1.beerShop.model.Cart;
import org.json.JSONArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by tom on 06/10/15.
 */

@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
public class CartService extends BaseService {


    @GET
    @Path("/all")
    public Response getAllCarts() {

        //Hardcore logging
        System.out.println("GET /cart/all");

        JSONArray result = new JSONArray();
        for(Map.Entry<String, Cart> entry: CartData.getData().entrySet()) {
            result.put(entry);
        }
        System.out.println(CartData.getData().size());
        return Response.ok().entity(result.toString(2)).build();
    }

    @GET
    @Path("/{userId}")
    public Response getCart(@PathParam("userId") String username) {

        //Hardcore logging
        System.out.println("GET /{userId} with {userId}=" + username + ".");
        System.out.println("Result : " + CartData.get(username));

        JSONArray result = new JSONArray();
        result.put(CartData.get(username));

        System.out.println(result);
        return Response.ok().entity(result.toString(2)).build();
    }
}
