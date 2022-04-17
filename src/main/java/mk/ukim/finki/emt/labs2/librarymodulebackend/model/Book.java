package mk.ukim.finki.emt.labs2.librarymodulebackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.enums.Category;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
