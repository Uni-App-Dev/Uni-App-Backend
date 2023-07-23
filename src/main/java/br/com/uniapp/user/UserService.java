package br.com.uniapp.user;

import br.com.uniapp.exception.bundle.EntityNotFoundException;
import br.com.uniapp.exception.bundle.UniException;
import br.com.uniapp.user.model.User;
import br.com.uniapp.user.model.UserDto;
import br.com.uniapp.utils.GeneralMessages;
import br.com.uniapp.validators.UserValidator;
import jakarta.validation.ConstraintViolationException;
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
    private UserValidator userValidator;

    public Page<UserDto> listAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(p -> modelMapper.map(p, UserDto.class));
    }

    public UserDto listById(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return modelMapper.map(optional.get(), UserDto.class);
    }

    public UserDto createUser(UserDto dto) throws UniException {
        User user = modelMapper.map(dto, User.class);
        try {
            userValidator.validateFields(user);
            userRepository.save(user);
        } catch (ConstraintViolationException e) {
            throw new UniException(e.getConstraintViolations().toString());
        }

        return modelMapper.map(user, UserDto.class);
    }

    public UserDto updateUser(UserDto dto) throws UniException {
        User user = modelMapper.map(dto, User.class);
        if(userRepository.findById(user.getId()).isEmpty()){
            throw new EntityNotFoundException("Usuário" + GeneralMessages.ENTITY_NOT_FOUND);
        }
        try {
            userValidator.validateFields(user);
            userRepository.save(user);
        } catch (ConstraintViolationException e) {
            throw new UniException(e.getConstraintViolations().toString());
        }

        return modelMapper.map(user, UserDto.class);
    }
}
