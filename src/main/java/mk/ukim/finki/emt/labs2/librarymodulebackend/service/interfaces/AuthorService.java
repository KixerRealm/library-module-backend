package mk.ukim.finki.emt.labs2.librarymodulebackend.service.interfaces;

import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Author;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Country;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author create(String name, String surname, Country country);

}
