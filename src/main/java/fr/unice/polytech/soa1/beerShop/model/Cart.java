package fr.unice.polytech.soa1.beerShop.model;

import java.util.HashMap;

/**
 * Created by tom on 05/10/15.
 */
public class Cart {
    private String owner;
    private HashMap<String,Float> cartData;

    public Cart( String owner, HashMap<String, Float> cartData) {
        this.cartData = cartData;
        this.owner = owner;
    }

    public Cart() {
        this.cartData = new HashMap<String, Float>();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public HashMap<String, Float> getCartData() {
        return cartData;
    }

    public void setCartData(HashMap<String, Float> cartData) {
        this.cartData = cartData;
    }
}
