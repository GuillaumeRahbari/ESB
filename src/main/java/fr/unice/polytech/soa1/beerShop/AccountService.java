package fr.unice.polytech.soa1.beerShop;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.soa1.beerShop.data.AccountData;
import fr.unice.polytech.soa1.beerShop.data.BeerData;
import fr.unice.polytech.soa1.beerShop.model.Account;
import fr.unice.polytech.soa1.beerShop.model.Beer;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Map;

/**
 * Created by guillaume on 28/09/2015.
 */
@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountService {

    @Path("/all")
    @GET
    public Response getAllAccount(@QueryParam("compte") String admin) {

        //Hardcore logging
        System.out.println("GET /account/all");

        if (!AccountData.getData().containsKey(admin)){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        ObjectMapper mapper = new ObjectMapper();

        //Map<String,Account> users = AccountData.getData();
        JSONArray result = new JSONArray();
        for(Map.Entry<String, Account> entry: AccountData.getData().entrySet()) {

            try {
                result.put(mapper.readValue(entry.toString(),Account.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    @POST
    public Response createAccount(String account){
        ObjectMapper mapper = new ObjectMapper();
        //Hardcore logging
        System.out.println("POST /account --- with " + account);
        try {
            Account account1 = mapper.readValue(account,Account.class);
            System.out.println("cc");
            if (!AccountData.getData().containsKey(account1.getUsername())){
                System.out.println("cc2");
                AccountData.add(account1);
                return  Response.ok().build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }



    @Path("/{name}/{password}")
    @GET
    public Response getAccount(@PathParam("name") String name, @PathParam("password") String password) {

        //Hardcore logging
        System.out.println("GET /account/{"+ name+"}/{"+password+"}");


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

    @DELETE
    @Path("/{id}")
    public Response deleteAccount (@PathParam("id") String accountName, @QueryParam("username") String username){
        //Hardcore logging
        System.out.println("DELETE /account/" + accountName + "?username=" + username);

        for(Map.Entry<String, Account> entry: AccountData.getData().entrySet()) {
            if (entry.getValue().getUsername().equals(username) && entry.getValue().getUsername().equals(accountName)){
                AccountData.delete(entry.getValue());
                return  Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/")
    public Response updateAccount (String accountUpdated, @QueryParam("username") String username) {
        ObjectMapper mapper = new ObjectMapper();
        //Hardcore logging
        System.out.println("PUT /beers/?username=" + username + " --- with " + accountUpdated);

        try {
            Account account = mapper.readValue(accountUpdated,Account.class);
            for(Map.Entry<String, Account> entry: AccountData.getData().entrySet()) {
                if (entry.getValue().getUsername().equals(username) && entry.getValue().getUsername().equals(account.getUsername())){
                    AccountData.update(account);
                    return  Response.ok().build();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

}