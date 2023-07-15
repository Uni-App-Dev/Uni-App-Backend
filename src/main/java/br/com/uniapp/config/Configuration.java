package br.com.uniapp.config;

import br.com.uniapp.Person.PersonValidator;
import br.com.uniapp.User.UserRepository;
import br.com.uniapp.User.UserValidator;
import br.com.uniapp.smallGroup.SmallGroupValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@org.springframework.context.annotation.Configuration
@RequiredArgsConstructor
public class Configuration {

    private final UserRepository userRepository;

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public PersonValidator personValidator() {
        return new PersonValidator();
    }
    @Bean
    public SmallGroupValidator smallGroupValidator() {
        return new SmallGroupValidator();
    }
    @Bean
    public UserValidator userValidator() {
        return new UserValidator();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
