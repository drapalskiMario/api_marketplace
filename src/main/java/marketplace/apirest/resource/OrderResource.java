package marketplace.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marketplace.apirest.entities.Order;
import marketplace.apirest.services.OrderService;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> findAll() {
        List<Order> ordersList = orderService.findAll();
        return ordersList;
    }

    @GetMapping(value = "/{id}")
    public Order findById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return order;
    }
}
