package ir.javapro.session3.service.book;


import ir.javapro.session3.dto.request.BookRequest;
import ir.javapro.session3.dto.respond.BookResponse;
import ir.javapro.session3.exeption.RuleException;
import ir.javapro.session3.model.Book;
import ir.javapro.session3.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Optional<Book>byName =
                bookRepository.findByName(bookRequest.getName());
        if (byName.isPresent())
            throw new RuleException("book.is.exist");
        Book save = bookRepository.save(createBook(bookRequest));
        return createBookResponse(save);
    }

    @Override
    public Page<BookResponse> findAll(Pageable pageable) {

        return bookRepository.findAll(pageable)
                .map((book)-> BookResponse.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build());
    }

    @Override
    public List<BookResponse> findByName(String name) {
        return bookRepository.findByNameContains("%"+name+"%")
                .stream().map((book) -> BookResponse.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse findById(Long id) {
       Book book = bookRepository.findById(id)
                .orElseThrow(()->new RuleException("id.not.found"));
       return createBookResponse(book);
    }

    private Book createBook(BookRequest bookRequest) {
        return Book.builder()
                .name(bookRequest.getName())
                .price(bookRequest.getPrice())
                .build();

    }

    private BookResponse createBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();

    }
}

