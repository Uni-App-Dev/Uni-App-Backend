package br.com.uniapp.auth;

import br.com.uniapp.model.Role;
import br.com.uniapp.model.User;
import br.com.uniapp.repository.UserRepository;
import br.com.uniapp.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest reuqest) {
        var user = User.builder()
                .firstName(reuqest.getFirstName())
                .lastName(reuqest.getLastNmae())
                .email(reuqest.getEmail())
                .password(passwordEncoder.encode(reuqest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest reuqest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reuqest.getEmail(), reuqest.getPassword()));
        var user = userRepository.findByEmail(reuqest.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
