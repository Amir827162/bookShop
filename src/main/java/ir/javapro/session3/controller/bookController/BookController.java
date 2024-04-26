package ir.javapro.session3.controller.bookController;


import ir.javapro.session3.dto.request.BookRequest;
import ir.javapro.session3.dto.respond.BookResponse;
import ir.javapro.session3.service.book.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> save(@RequestBody @Valid BookRequest book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok(bookService.findAll(pageable));
    }

}