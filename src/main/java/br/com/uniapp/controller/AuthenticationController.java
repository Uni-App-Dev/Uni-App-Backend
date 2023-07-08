package br.com.uniapp.controller;

import br.com.uniapp.Exception.bundle.UniException;
import br.com.uniapp.model.AuthenticationRequest;
import br.com.uniapp.model.AuthenticationResponse;
import br.com.uniapp.service.AuthenticationService;
import br.com.uniapp.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest reuqest) throws UniException {
        return ResponseEntity.ok().body(authenticationService.register(reuqest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest reuqest) throws UniException {
        return ResponseEntity.ok().body(authenticationService.authenticate(reuqest));
    }
}