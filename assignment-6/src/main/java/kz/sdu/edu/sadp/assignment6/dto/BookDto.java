package kz.sdu.edu.sadp.assignment6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String author;
    private String name;
    private Integer price;
}
