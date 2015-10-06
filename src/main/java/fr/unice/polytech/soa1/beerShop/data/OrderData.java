package fr.unice.polytech.soa1.beerShop.data;

import fr.unice.polytech.soa1.beerShop.model.Cart;
import fr.unice.polytech.soa1.beerShop.model.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tom on 06/10/15.
 */
public class OrderData {
    private static Map<Long, Order> data = DaoUtils.readData("orderData.json", Long.class, Order.class);
    private static Long nextId=new Long(data.size());

    public static Order get(Long orderId){
        return data.get(orderId);
    }

    public static void add(Order order){
        order.setId(nextId++);
        data.put(order.getId(),order);
    }

    public static void update(Order order){
        delete(order.getId());
        data.put(order.getId(), order);
    }

    public static void delete(Order order){
        data.remove(order.getId());
    }

    public static void delete(Long orderId){
        data.remove(orderId);
    }

    public static Map<Long, Order> getData() {
        return data;
    }
}
