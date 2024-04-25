package kz.sdu.edu.sadp.assignment6.service;

import kz.sdu.edu.sadp.assignment6.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    BookDto findById(Long id);

    List<BookDto> search(BookDto bookDto);

    List<BookDto> findAll();

    BookDto createBook(BookDto bookDto);

    BookDto updateById(Long id, BookDto bookDto);

    void deleteById(Long id);
}
