package mk.ukim.finki.emt.labs2.librarymodulebackend.service.interfaces;

import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    Country create(String name, String continent);
}
