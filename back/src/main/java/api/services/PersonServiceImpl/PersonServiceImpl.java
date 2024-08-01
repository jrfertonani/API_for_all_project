package api.services.PersonServiceImpl;

import api.domain.Person;
import api.domain.dto.personDTO;
import api.repositories.PersonRepository;
import api.services.PersonService;
import api.services.exceptions.DataIntegrityViolationException;
import api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PersonRepository repository;


    @Override
    public Person create(personDTO DTO) {
        return repository.save(mapper.map(DTO, Person.class));
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person findById(Integer id) {
        Optional<Person> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!! " + id));
    }

    @Override
    public Person update(personDTO DTO) {
        return repository.save(
                mapper.map(DTO, Person.class));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
