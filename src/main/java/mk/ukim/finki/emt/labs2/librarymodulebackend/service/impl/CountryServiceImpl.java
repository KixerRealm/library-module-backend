package mk.ukim.finki.emt.labs2.librarymodulebackend.service.impl;

import mk.ukim.finki.emt.labs2.librarymodulebackend.model.Country;
import mk.ukim.finki.emt.labs2.librarymodulebackend.repository.CountryRepository;
import mk.ukim.finki.emt.labs2.librarymodulebackend.service.interfaces.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country create(String name, String continent) {
        Country country = new Country(name, continent);
        return this.countryRepository.save(country);
    }
}
