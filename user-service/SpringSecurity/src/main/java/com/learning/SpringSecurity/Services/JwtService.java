package com.learning.SpringSecurity.Services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@Setter
@Getter
@Service
public class JwtService {

    private String secretKey="";

    JwtService() throws NoSuchAlgorithmException {
        KeyGenerator keyGen= KeyGenerator.getInstance("HmacSHA256");
        SecretKey sk= keyGen.generateKey();
        setSecretKey(Base64.getEncoder().encodeToString(sk.getEncoded()));
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 10*60*60*60))
                .and()
                .signWith(generateKey())
                .compact();
    }

    private Key generateKey() {
        try {
            byte[] bytes = Decoders.BASE64.decode(secretKey);
            return Keys.hmacShaKeyFor(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String exractUsername(String token) {
        return "";
    }

    public boolean validateToken(UserDetails userInfo, String token) {
        return true;
    }
}
