package kz.sdu.edu.sadp.assignment6.service.impl;


import kz.sdu.edu.sadp.assignment6.adapter.BookAdapter;
import kz.sdu.edu.sadp.assignment6.dto.BookDto;
import kz.sdu.edu.sadp.assignment6.model.Book;
import kz.sdu.edu.sadp.assignment6.repository.BookRepository;
import kz.sdu.edu.sadp.assignment6.service.BookService;
import kz.sdu.edu.sadp.assignment6.service.SpecificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final SpecificationService specificationService;

    @Override
    public BookDto findById(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isEmpty()) {
            throw new IllegalArgumentException(String.format("Book with id %s not found", id));
        }
        return BookAdapter.toDto(byId.get());
    }

    @Override
    public List<BookDto> search(BookDto bookDto) {
        return bookRepository.findAll(specificationService.getBookSpecification(bookDto))
                .stream().map(BookAdapter::toDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(BookAdapter::toDto).collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = BookAdapter.toEntity(bookDto);
        return BookAdapter.toDto(bookRepository.save(book));
    }

    @Override
    public BookDto updateById(Long id, BookDto bookDto) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isEmpty()) {
            throw new IllegalArgumentException(String.format("Book with id %s not found", id));
        }
        Book book = byId.get();
        if (bookDto.getName() != null && !bookDto.getName().equals(book.getName())) {
            book.setName(bookDto.getName());
        }
        if (bookDto.getAuthor() != null && !bookDto.getAuthor().equals(book.getAuthor())) {
            book.setAuthor(book.getAuthor());
        }
        if (bookDto.getPrice() != null && !bookDto.getPrice().equals(book.getPrice())) {
            book.setPrice(bookDto.getPrice());
        }
        return BookAdapter.toDto(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
