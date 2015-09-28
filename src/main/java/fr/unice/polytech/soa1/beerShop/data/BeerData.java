package fr.unice.polytech.soa1.beerShop.data;

import fr.unice.polytech.soa1.beerShop.model.Beer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tom on 28/09/15.
 */
public class BeerData {
    private static final Map<String, Beer> data= new HashMap<String,Beer>(){
        {
            this.put("GuiBeer", new Beer("GuiBeer"));
            this.put("Hankook", new Beer("Hankook"));
            this.put("Leffe", new Beer("Leffe"));
            this.put("Mort Subite", new Beer("Mort Subite"));
            this.put("YoBeer", new Beer("YoBeer"));
        }
    };

    public static Beer getBeer(String id){
        return data.get(id);
    }

    public static void save(Beer beer){
        data.put(beer.getName(),beer);
    }

}
