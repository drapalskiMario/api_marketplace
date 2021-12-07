package marketplace.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.apirest.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
