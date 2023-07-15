package br.com.uniapp.smallGroup;

import br.com.uniapp.Person.model.Person;
import br.com.uniapp.Person.PersonRepository;
import br.com.uniapp.Person.model.PersonDto;
import br.com.uniapp.Person.model.PersonOutputDto;
import br.com.uniapp.smallGroup.model.SmallGroup;
import br.com.uniapp.smallGroup.model.SmallGroupDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Page<SmallGroupDto> smallGroupDtoList = smallGroupRepository.findAll(pageable).map(p -> modelMapper.map(p, SmallGroupDto.class));
        for (SmallGroupDto dto : smallGroupDtoList.getContent()) {
            dto.setMembers(personRepository.findBySmallGroupId(dto.getId()).stream().map(p -> modelMapper.map(p, PersonOutputDto.class)).collect(Collectors.toList()));
        }
        return smallGroupDtoList;
    }

    public SmallGroupDto listById(Long id) {
        Optional<SmallGroup> optional = smallGroupRepository.findById(id);

        return modelMapper.map(optional.get(), SmallGroupDto.class);
    }

    public SmallGroupDto createSmallGroup(SmallGroupDto dto) {
        SmallGroup smallGroup = modelMapper.map(dto, SmallGroup.class);
        smallGroupRepository.save(smallGroup);
        return modelMapper.map(smallGroup, SmallGroupDto.class);
    }

    public SmallGroupDto updateSmallGroup(SmallGroupDto dto) {
        SmallGroup smallGroup = modelMapper.map(dto, SmallGroup.class);
        smallGroupRepository.save(smallGroup);
        return modelMapper.map(smallGroup, SmallGroupDto.class);
    }


}
