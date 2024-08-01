package api.resources;

import api.domain.Person;
import api.domain.dto.personDTO;
import api.services.PersonService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<personDTO> create(@Valid @RequestBody personDTO DTO) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service.create(DTO)
                        .getId())
                .toUri();
        return ResponseEntity.created(uri).body(DTO);
    };


    @GetMapping
    public ResponseEntity<List<personDTO>> findAll(){
        List<Person> list = service.findAll();
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream().map(x -> mapper.map(x, personDTO.class))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<personDTO> findById(@PathVariable Integer id){
        return  ResponseEntity.ok().body(
                mapper.map(service.findById(id),
                        personDTO.class)
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<personDTO> update(@PathVariable Integer id,
                                            @Valid @RequestBody personDTO DTO){
       Person obj = service.update(DTO);
        return ResponseEntity.ok().body(DTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
