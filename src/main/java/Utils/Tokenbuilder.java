package Utils;

import domain.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Calendar;

public class Tokenbuilder {
    private Key key;
    public Tokenbuilder(Key key){
        this.key = key;
    }
    public String createUserToken(Users users){
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE,60);
        String JWT = Jwts.builder()
                .setIssuer("localhost")
                .setSubject("userlogin")
                .setExpiration(expiration.getTime())
                .claim("id",users.getId())
                .claim("role",users.getRol())
                .claim("username",users.getEmail())
                .claim("vendor",users.getVendor())
                .signWith(SignatureAlgorithm.HS512,key)
                .compact();
        return JWT;
    }
}
