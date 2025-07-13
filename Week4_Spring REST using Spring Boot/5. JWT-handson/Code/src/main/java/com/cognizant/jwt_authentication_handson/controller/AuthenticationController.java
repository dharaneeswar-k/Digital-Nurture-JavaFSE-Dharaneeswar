package com.cognizant.jwt_authentication_handson.controller;

import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.*;

@RestController
public class AuthenticationController {

    // ✅ Secure key generator for HS256 (no WeakKey error)
    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

    private String getUser(String authHeader) {
        String encoded = authHeader.substring(6); // Skip "Basic "
        byte[] decoded = Base64.getDecoder().decode(encoded);
        return new String(decoded).split(":")[0];
    }

    private String generateJwt(String user) {
        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 min
                .signWith(secretKey) // ✅ Secure key
                .compact();
    }
}
