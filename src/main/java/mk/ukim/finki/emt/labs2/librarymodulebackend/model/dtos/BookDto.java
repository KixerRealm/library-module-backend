package mk.ukim.finki.emt.labs2.librarymodulebackend.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Author;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.enums.Category;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

}
