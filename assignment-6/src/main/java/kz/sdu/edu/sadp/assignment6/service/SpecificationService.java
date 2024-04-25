package kz.sdu.edu.sadp.assignment6.service;

import kz.sdu.edu.sadp.assignment6.dto.BookDto;
import kz.sdu.edu.sadp.assignment6.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpecificationService {

    public Specification<Book> getBookSpecification(BookDto bookDto) {
        return Specification.where(((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (bookDto.getAuthor() != null) {
                predicates.add(criteriaBuilder.like(root.get("author"), "%" + bookDto.getAuthor() + "%"));
            }
            if (bookDto.getName() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + bookDto.getName() + "%"));
            }
            if (bookDto.getPrice() != null) {
                predicates.add(criteriaBuilder.equal(root.get("price"), bookDto.getPrice()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }));
    }
}
