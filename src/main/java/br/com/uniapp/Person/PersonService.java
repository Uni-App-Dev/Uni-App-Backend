package br.com.uniapp.Person;

import br.com.uniapp.Exception.bundle.PersonNotFoundException;
import br.com.uniapp.Exception.bundle.SmallGroupNotFoundException;
import br.com.uniapp.Exception.bundle.UniException;
import br.com.uniapp.Person.model.Person;
import br.com.uniapp.Person.model.PersonDto;
import br.com.uniapp.Person.model.PersonOutputDto;
import br.com.uniapp.Utils.GeneralMessages;
import br.com.uniapp.smallGroup.SmallGroupRepository;
import br.com.uniapp.smallGroup.model.SmallGroup;
import br.com.uniapp.smallGroup.model.SmallGroupDto;
import br.com.uniapp.smallGroup.model.SmallGroupOutputDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SmallGroupRepository smallGroupRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Page<PersonDto> listAll(Pageable pageable) {
        return personRepository.findAll(pageable).map(p -> modelMapper.map(p, PersonDto.class));
    }

    public PersonDto listById(Long id) {
        Optional<Person> optional = personRepository.findById(id);

        return modelMapper.map(optional.get(), PersonDto.class);
    }

    public PersonDto createPerson(PersonDto dto) throws UniException {
        Person person = modelMapper.map(dto, Person.class);
        if(dto.getSmallGroup() != null) {
            person.setSmallGroup(this.findSmallGroup(dto.getSmallGroup().getId()));
        }
        personRepository.save(person);
        return modelMapper.map(person, PersonDto.class);
    }

    public PersonDto updatePerson(PersonDto dto) throws UniException {
        Person person = modelMapper.map(dto, Person.class);
        if(dto.getSmallGroup() != null) {
            person.setSmallGroup(this.findSmallGroup(dto.getSmallGroup().getId()));
        }
        if(personRepository.existsById(person.getId())){
            personRepository.save(person);
            return modelMapper.map(person, PersonDto.class);
        } else {
            throw new PersonNotFoundException(GeneralMessages.PERSON_NOT_FIND);
        }
    }

    private SmallGroup findSmallGroup(Long id) throws UniException {
        Optional<SmallGroup> result = smallGroupRepository.findById(id);
        if(result.isEmpty()) {
            throw new SmallGroupNotFoundException(GeneralMessages.SMALL_GROUP_NOT_FOUND);
        }
        return result.get();
    }
}
