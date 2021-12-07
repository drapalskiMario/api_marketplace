package marketplace.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.apirest.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
