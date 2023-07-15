package br.com.uniapp.User.model;

import br.com.uniapp.Security.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private String token;
    private Role role;
}
