package kz.sdu.edu.sadp.assignment6.repository;

import kz.sdu.edu.sadp.assignment6.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    Optional<Book> findByName(String name);

    Optional<Book> findByAuthor(String author);
}
