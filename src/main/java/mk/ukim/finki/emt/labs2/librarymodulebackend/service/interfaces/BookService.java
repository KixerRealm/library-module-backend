package mk.ukim.finki.emt.labs2.librarymodulebackend.service.interfaces;

import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Book;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.dtos.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    Book taken(Long id);

    void deleteById(Long id);
}
