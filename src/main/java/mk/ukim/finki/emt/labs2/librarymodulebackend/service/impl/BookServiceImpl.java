package mk.ukim.finki.emt.labs2.librarymodulebackend.service.impl;

import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Author;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Book;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.dtos.BookDto;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.labs2.librarymodulebackend.repository.AuthorRepository;
import mk.ukim.finki.emt.labs2.librarymodulebackend.repository.BookRepository;
import mk.ukim.finki.emt.labs2.librarymodulebackend.service.interfaces.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Book taken(Long id) {
        Book book = findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if(book.getAvailableCopies() <= 0);
        else book.setAvailableCopies(book.getAvailableCopies() - 1);
        return this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
