package se.assignment6.api6.APIBookOrder;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

import se.assignment6.api6.APIBookInventory.BookInventoryController;

@Service
public class BookOrderService {
    
    private List<Order> orders = new ArrayList<>(List.of(
        new Order("O001", "B001", 2, LocalDate.now()),
        new Order("O002", "B002", 3, LocalDate.of(2023, 5, 10)),
        new Order("O003", "B003", 1, LocalDate.of(2023, 5, 23))
    ));
    
    //GET order specific
    public Order getOrder(String id) {
        return orders.stream().filter(order -> order.getOrderID().equals(id)).findFirst().get();
    }

    //GET all orders
    public List<Order> getAllOrders () {
        return orders;
    }

    //POST 
    public String placeOrder(Order order) {
        orders.add(order);
        return "Order created successfully";
    }


    //DELETE
    public void deleteOrder(String orderID) {
        orders.removeIf(order -> order.getOrderID().equals(orderID));
    }

}
