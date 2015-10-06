package fr.unice.polytech.soa1.beerShop.model;

/**
 * Created by tom on 28/09/15.
 */
public class Beer {
    private String name;
    private String user;

    public Beer(){

    }

    public Beer(String name, String user) {
        this.name = name;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return name;
    }
}
