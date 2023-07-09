package br.com.uniapp.Person;

import br.com.uniapp.Person.model.PersonDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public Page<PersonDto> listAll(@ParameterObject @PageableDefault(size = 10) Pageable pageable){
        return personService.listAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable @NotNull Long id){
        PersonDto person = personService.listById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@RequestBody @Valid PersonDto person, UriComponentsBuilder uri) {
        PersonDto createdPerson = personService.savePerson(person);
        URI address = uri.path("person/{id}").buildAndExpand(createdPerson.getId()).toUri();
        return ResponseEntity.created(address).body(createdPerson);
    }
}
