package api.services;

import api.domain.Person;
import api.domain.dto.personDTO;

import java.util.List;

public interface PersonService {

    Person create(personDTO DTO);
    List<Person> findAll();
    Person findById(Integer id);
    Person update(personDTO DTO);
    void delete(Integer id);

}
