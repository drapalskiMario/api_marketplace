package marketplace.apirest.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import marketplace.apirest.entities.User;
import marketplace.apirest.entities.enums.OrderStatus;
import marketplace.apirest.entities.Category;
import marketplace.apirest.entities.Order;
import marketplace.apirest.entities.OrderItem;
import marketplace.apirest.entities.Payment;
import marketplace.apirest.entities.Product;
import marketplace.apirest.repositories.CategoryRepository;
import marketplace.apirest.repositories.OrderItemRepository;
import marketplace.apirest.repositories.OrderRepository;
import marketplace.apirest.repositories.ProductRepository;
import marketplace.apirest.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User user01 = new User(null, "Mario Jr", "mario@mail.com", "992391101", "12345");
        User user02 = new User(null, "João Silva", "joao@mail.com", "992391204", "12345");

        userRepository.saveAll(Arrays.asList(user01, user02));

        Order order01 = new Order(null, Instant.parse("2021-12-03T01:05:02Z"), OrderStatus.PAID, user01);
        Order order02 = new Order(null, Instant.parse("2021-12-03T01:16:04Z"), OrderStatus.WAITING_PAYMENT, user02);

        orderRepository.saveAll(Arrays.asList(order01, order02));

        Category category01 = new Category(null, "Eletronics");
        Category category02 = new Category(null, "Books");
        Category category03 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(category01, category02, category03));

        Product product01 = new Product(null, "The Lord of the Rings", "Lorem Ipsum", 90.5, "");
        Product product02 = new Product(null, "Mackbook M1Max", "Lorem Ipsum", 1500.00, "");
        Product product03 = new Product(null, "Smart TV 50'", "Lorem Ipsum", 200.00, "");

        productRepository.saveAll(Arrays.asList(product01, product02, product03));

        product01.getCategories().add(category02);
        product02.getCategories().add(category01);
        product02.getCategories().add(category03);
        product03.getCategories().add(category02);

        productRepository.saveAll(Arrays.asList(product01, product02, product03));

        OrderItem orderItem01 = new OrderItem(order01, product01, 2, product01.getPrice());
        OrderItem orderItem02 = new OrderItem(order01, product03, 1, product03.getPrice());
        OrderItem orderItem03 = new OrderItem(order02, product03, 2, product03.getPrice());
        OrderItem orderItem04 = new OrderItem(order02, product02, 2, product02.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem01, orderItem02, orderItem03, orderItem04));

        Payment payment01 = new Payment(null, Instant.parse("2021-12-05T01:16:04Z"), order01);
        order01.setPayment(payment01);

        orderRepository.save(order01);
    }
}
