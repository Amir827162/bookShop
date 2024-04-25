package ir.javapro.session3.repository;

import ir.javapro.session3.model.Factor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactorRepository extends JpaRepository<Factor, Long> {
}
