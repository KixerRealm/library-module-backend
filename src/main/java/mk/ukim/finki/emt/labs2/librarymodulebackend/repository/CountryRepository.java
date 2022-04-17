package mk.ukim.finki.emt.labs2.librarymodulebackend.repository;

import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
