package br.com.uniapp.user;

import br.com.uniapp.exception.bundle.UniException;
import br.com.uniapp.user.model.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Page<UserDto> listAll(@ParameterObject @PageableDefault(size = 10) Pageable pageable){
        return userService.listAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable @NotNull Long id){
        UserDto user = userService.listById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserDto user, UriComponentsBuilder uri) throws UniException {
        UserDto createdUser = userService.createUser(user);
        URI address = uri.path("user/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(address).body(createdUser);
    }
}
