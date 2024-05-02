package ir.javapro.session3.service.book;

import ir.javapro.session3.dto.request.BookRequest;
import ir.javapro.session3.dto.respond.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookResponse save(BookRequest bookRequest);

    Page<BookResponse> findAll(Pageable pageable);

    List<BookResponse> findByName(String name);

    BookResponse findById(Long id);

    void deleted(Long id);
}
