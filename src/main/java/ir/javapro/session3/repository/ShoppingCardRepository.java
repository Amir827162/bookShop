package ir.javapro.session3.repository;

import ir.javapro.session3.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRepository extends JpaRepository<ShoppingCard, Long> {
}
