package mk.ukim.finki.emt.labs2.librarymodulebackend.repository;

import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
