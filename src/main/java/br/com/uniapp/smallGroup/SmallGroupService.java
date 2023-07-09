package br.com.uniapp.smallGroup;

import br.com.uniapp.Person.model.Person;
import br.com.uniapp.Person.PersonRepository;
import br.com.uniapp.smallGroup.model.SmallGroup;
import br.com.uniapp.smallGroup.model.SmallGroupDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SmallGroupService {

    @Autowired
    SmallGroupRepository smallGroupRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ModelMapper modelMapper;

    public Page<SmallGroupDto> listAll(Pageable pageable) {
        return smallGroupRepository.findAll(pageable)
                .map(p -> modelMapper.map(p, SmallGroupDto.class));
    }

    public SmallGroupDto listById(Long id) {
        Optional<SmallGroup> optional = smallGroupRepository.findById(id);

        return modelMapper.map(optional.get(), SmallGroupDto.class);
    }

    public SmallGroupDto saveSmallGroup(SmallGroupDto dto) {
        SmallGroup smallGroup = modelMapper.map(dto, SmallGroup.class);
        smallGroupRepository.save(smallGroup);
        for (Person leader : smallGroup.getLeaders()) {
            personRepository.bindSmallGroupLead(smallGroup, leader.getId());
        }
        if(!smallGroup.getMembers().isEmpty()){
            for (Person member : smallGroup.getMembers()) {
                personRepository.bindSmallGroup(smallGroup, member.getId());
            }
        }
        return modelMapper.map(smallGroup, SmallGroupDto.class);
    }


}
