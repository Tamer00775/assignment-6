package kz.sdu.edu.sadp.assignment6.adapter;

import kz.sdu.edu.sadp.assignment6.dto.BookDto;
import kz.sdu.edu.sadp.assignment6.model.Book;

public class BookAdapter {

    public static BookDto toDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .name(book.getName())
                .price(book.getPrice()).build();
    }

    public static Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setName(bookDto.getName());
        book.setPrice(bookDto.getPrice());
        return book;
    }
}
