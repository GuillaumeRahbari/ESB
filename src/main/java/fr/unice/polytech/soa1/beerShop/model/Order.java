package fr.unice.polytech.soa1.beerShop.model;

/**
 * Created by tom on 06/10/15.
 */
public class Order {
    private Cart cart;
    private Long creditCard;
    private Long id;

    public Order() {
    }

    public Order(Cart cart, Long creditCard, Long id) {
        this.cart = cart;
        this.creditCard = creditCard;
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Long creditCard) {
        this.creditCard = creditCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
