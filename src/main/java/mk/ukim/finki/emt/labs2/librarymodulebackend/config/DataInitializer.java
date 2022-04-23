package mk.ukim.finki.emt.labs2.librarymodulebackend.config;

import mk.ukim.finki.emt.labs2.librarymodulebackend.model.dtos.BookDto;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.enums.Category;
import mk.ukim.finki.emt.labs2.librarymodulebackend.service.interfaces.AuthorService;
import mk.ukim.finki.emt.labs2.librarymodulebackend.service.interfaces.BookService;
import mk.ukim.finki.emt.labs2.librarymodulebackend.service.interfaces.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public DataInitializer(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    private Category randomizeCategoryType(int i){
        if (i % 7 == 0) return Category.NOVEL;
        else if(i % 7 == 1) return Category.THRILLER;
        else if(i % 7 == 2) return Category.HISTORY;
        else if(i % 7 == 3) return Category.FANTASY;
        else if(i % 7 == 4) return Category.BIOGRAPHY;
        else if(i % 7 == 5) return Category.CLASSICS;
        else return Category.DRAMA;
    }

    @PostConstruct
    public void initData(){

        for (int i = 1; i < 8; i++) {
            this.countryService.create("Country " + i,"Continent " + i);
        }
        for (int i = 1; i < 15; i++) {
            this.authorService.create("Author Name " + i, "Author Surname " + i, this.countryService.findAll().get((i-1) % 7));
        }
//        for (int i = 1; i < 15; i++) {
//            this.bookService.save(new BookDto("Book " + i, this.randomizeCategoryType(i),this.authorService.findAll().get((i - 1) % 14).getId(),i));
//        }
    }
}
