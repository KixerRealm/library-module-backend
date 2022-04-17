package mk.ukim.finki.emt.labs2.librarymodulebackend.web;


import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Book;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.dtos.BookDto;
import mk.ukim.finki.emt.labs2.librarymodulebackend.model.enums.Category;
import mk.ukim.finki.emt.labs2.librarymodulebackend.service.interfaces.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"/", "/books"})
    private List<Book> findAll(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/categories")
    public Category[] findCategories(){
        return Category.values();
    }

    @PostMapping("/books/{id}/take")
    public String take(@PathVariable Long id) {
        this.bookService.taken(id);
        return "redirect:/books";
    }
}
