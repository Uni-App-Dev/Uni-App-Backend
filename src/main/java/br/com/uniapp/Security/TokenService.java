package br.com.uniapp.Security;

import br.com.uniapp.User.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class TokenService {

    private static final long expirationTime = 18000000;
    private String key = "String aleatoria";
    public String generateToken(User user){
        return  Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject("Teste")
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
}
