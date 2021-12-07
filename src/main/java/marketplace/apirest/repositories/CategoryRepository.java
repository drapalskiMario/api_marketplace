package marketplace.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.apirest.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
