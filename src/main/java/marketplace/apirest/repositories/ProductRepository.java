package marketplace.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.apirest.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
