package br.com.uniapp.User;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<UserDto> listAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(p -> modelMapper.map(p, UserDto.class));
    }

    public UserDto listById(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return modelMapper.map(optional.get(), UserDto.class);
    }

    public UserDto savePerson(UserDto dto) {
        User person = modelMapper.map(dto, User.class);
        userRepository.save(person);
        return modelMapper.map(person, UserDto.class);
    }
}
