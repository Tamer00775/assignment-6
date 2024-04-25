package kz.sdu.edu.sadp.assignment6.controller;

import kz.sdu.edu.sadp.assignment6.dto.BookDto;
import kz.sdu.edu.sadp.assignment6.service.BookService;
import kz.sdu.edu.sadp.assignment6.utils.Endpoints;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;

    @GetMapping(Endpoints.BookControllerPath.GET_ALL)
    public ResponseEntity<List<BookDto>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping(Endpoints.BookControllerPath.SEARCH)
    public ResponseEntity<List<BookDto>> search(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.search(bookDto));
    }

    @GetMapping(Endpoints.BookControllerPath.GET_BY_ID)
    public ResponseEntity<BookDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping(Endpoints.BookControllerPath.CREATE)
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.createBook(bookDto));
    }

    @PutMapping(Endpoints.BookControllerPath.UPDATE)
    public ResponseEntity<BookDto> update(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.updateById(id, bookDto));
    }

    @DeleteMapping(Endpoints.BookControllerPath.DELETE)
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
