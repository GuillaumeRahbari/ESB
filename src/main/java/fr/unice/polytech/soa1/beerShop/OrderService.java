package fr.unice.polytech.soa1.beerShop;

import fr.unice.polytech.soa1.beerShop.data.CartData;
import fr.unice.polytech.soa1.beerShop.data.OrderData;
import fr.unice.polytech.soa1.beerShop.model.Cart;
import fr.unice.polytech.soa1.beerShop.model.Order;
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

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderService {

    @GET
    @Path("/all")
    public Response getAllOrders() {

        //Hardcore logging
        System.out.println("GET /orders/all");

        JSONArray result = new JSONArray();
        for(Map.Entry<Long, Order> entry: OrderData.getData().entrySet()) {
            result.put(entry);
        }
        System.out.println(CartData.getData().size());
        return Response.ok().entity(result.toString(2)).build();
    }

    @GET
    @Path("/{orderId}")
    public Response getCart(@PathParam("orderId") Long orderId) {

        //Hardcore logging
        System.out.println("GET /{orderId} with {orderId}=" + orderId + ".");
        System.out.println("Result : " + OrderData.get(orderId));

        JSONArray result = new JSONArray();
        result.put(OrderData.get(orderId));

        System.out.println(result);
        return Response.ok().entity(result.toString(2)).build();
    }
}
