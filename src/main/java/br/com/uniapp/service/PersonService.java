package br.com.uniapp.service;

import br.com.uniapp.model.Person;
import br.com.uniapp.model.dto.PersonDto;
import br.com.uniapp.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PersonDto> listAll(Pageable pageable) {
        return personRepository.findAll(pageable)
                .map(p -> modelMapper.map(p, PersonDto.class));
    }

    public PersonDto listById(Long id) {
        Optional<Person> optional = personRepository.findById(id);

        return modelMapper.map(optional.get(), PersonDto.class);
    }

    public PersonDto savePerson(PersonDto dto) {
        Person person = modelMapper.map(dto, Person.class);
        personRepository.save(person);
        return modelMapper.map(person, PersonDto.class);
    }
}
