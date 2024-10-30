package com.example.demo.service.impl;

import com.example.demo.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secretKey}")
    private String secretKey;
    @Override
    public String generateToken(UserDetails user) {
        return generateTokenKey(new HashMap<>(),user);
    }

    @Override
    public String extractUsername(String token) {
        return extracClaim(token,Claims::getSubject);
    }

    @Override
    public boolean validateToken(String token, UserDetails user) {
        return false;
    }

    public String generateTokenKey(Map<String,Object> claim,UserDetails userDetails){
        return Jwts.builder()
                .setClaims(claim)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getKey(){
        byte[] keBytes= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keBytes);
    }
    private <T> T extracClaim(String token, Function<Claims,T> claimResolver){
        final Claims claims=extraAllClaim(token);
        return claimResolver.apply(claims);
    }

    private Claims extraAllClaim(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }
}
