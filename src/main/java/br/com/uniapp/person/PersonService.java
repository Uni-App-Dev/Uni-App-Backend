package br.com.uniapp.person;

import br.com.uniapp.exception.bundle.EntityNotFoundException;
import br.com.uniapp.exception.bundle.UniException;
import br.com.uniapp.person.model.Person;
import br.com.uniapp.person.model.PersonDto;
import br.com.uniapp.utils.GeneralMessages;
import br.com.uniapp.smallGroup.SmallGroupRepository;
import br.com.uniapp.smallGroup.model.SmallGroup;
import br.com.uniapp.validators.PersonValidator;
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
    private SmallGroupRepository smallGroupRepository;
    @Autowired
    private ModelMapper modelMapper;
    private PersonValidator personValidator;

    public Page<PersonDto> listAll(Pageable pageable) {
        return personRepository.findAll(pageable).map(p -> modelMapper.map(p, PersonDto.class));
    }

    public PersonDto listById(Long id) throws UniException {
        Optional<Person> optional = personRepository.findById(id);
        if(optional.isEmpty()){
            throw new EntityNotFoundException(GeneralMessages.PERSON_NOT_FIND);
        }
        return modelMapper.map(optional.get(), PersonDto.class);
    }

    public PersonDto createPerson(PersonDto dto) throws UniException {
        Person person = modelMapper.map(dto, Person.class);
        if(dto.getSmallGroup() != null) {
            person.setSmallGroup(this.findSmallGroup(dto.getSmallGroup().getId()));
        }
        personValidator.validateFields(person);
        personRepository.save(person);
        return modelMapper.map(person, PersonDto.class);
    }

    public PersonDto updatePerson(PersonDto dto) throws UniException {
        Person person = modelMapper.map(dto, Person.class);
        if(dto.getSmallGroup() != null) {
            person.setSmallGroup(this.findSmallGroup(dto.getSmallGroup().getId()));
        }
        if(personRepository.findById(person.getId()).isEmpty()){
            throw new EntityNotFoundException("Pessoa" + GeneralMessages.ENTITY_NOT_FOUND);
        }
        personValidator.validateFields(person);
        personRepository.save(person);
        return modelMapper.map(person, PersonDto.class);

    }

    private SmallGroup findSmallGroup(Long id) throws UniException {
        Optional<SmallGroup> result = smallGroupRepository.findById(id);
        if(result.isEmpty()) {
            throw new EntityNotFoundException(GeneralMessages.SMALL_GROUP_NOT_FOUND);
        }
        return result.get();
    }
}
