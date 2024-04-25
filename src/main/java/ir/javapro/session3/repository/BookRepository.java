package ir.javapro.session3.repository;

import ir.javapro.session3.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
