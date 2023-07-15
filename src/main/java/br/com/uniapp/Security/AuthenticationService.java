package br.com.uniapp.Security;

import br.com.uniapp.Exception.bundle.AuthenticationAppException;
import br.com.uniapp.Exception.bundle.UniException;
import br.com.uniapp.Person.PersonValidator;
import br.com.uniapp.Security.jwt.JwtService;
import br.com.uniapp.Security.model.AuthenticationRequest;
import br.com.uniapp.Security.model.AuthenticationResponse;
import br.com.uniapp.Security.model.RegisterRequest;
import br.com.uniapp.Security.model.Role;
import br.com.uniapp.User.model.User;
import br.com.uniapp.User.UserRepository;
import br.com.uniapp.Utils.GeneralMessages;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PersonValidator personValidator;

    public AuthenticationResponse register(RegisterRequest reuqest) throws UniException {
        var email = userRepository.findByEmail(reuqest.getEmail());
        if(email.isPresent()){
            throw new AuthenticationAppException(GeneralMessages.EMAIL_ALREADY_REGISTERED);
        }
        var user = User.builder()
                .person(reuqest.getPerson())
                .email(reuqest.getEmail())
                .password(passwordEncoder.encode(reuqest.getPassword()))
                .role(Role.USER)
                .build();
        personValidator.validateFields(user.getPerson());
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest reuqest) throws UniException {
        var user = userRepository.findByEmail(reuqest.getEmail());
        if(user.isEmpty()){
            throw new AuthenticationAppException(GeneralMessages.EMAIL_NOT_FOUND);
        }
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reuqest.getEmail(), reuqest.getPassword()));
        } catch (AuthenticationException e) {
            throw new AuthenticationAppException(GeneralMessages.LOGIN_FAILED);
        }
        var jwtToken = jwtService.generateToken(user.get());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
