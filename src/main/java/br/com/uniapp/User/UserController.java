package br.com.uniapp.User;

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
        UserDto person = userService.listById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserDto person, UriComponentsBuilder uri) {
        UserDto createdPerson = userService.savePerson(person);
        URI address = uri.path("person/{id}").buildAndExpand(createdPerson.getId()).toUri();
        return ResponseEntity.created(address).body(createdPerson);
    }
}
