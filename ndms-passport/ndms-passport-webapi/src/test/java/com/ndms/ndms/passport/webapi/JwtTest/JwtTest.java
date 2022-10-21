package com.ndms.ndms.passport.webapi.JwtTest;

import com.ndms.ndms.commons.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

/**
 * 時間:2022/10/20  上午 05:39
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@SpringBootTest
@Slf4j
public class JwtTest {

    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void testJwt(){
        Map<String,Object> claims = new HashMap<>();
        //claims.put("id",123);
        claims.put("username","root");

        String s = jwtUtils.generateToken(claims);
        System.out.println(s);

    }

    @Test
    public void testJwt2(){
        Map<String,Object> claims = new HashMap<>();
        //claims.put("id",123);
        claims.put("username","root");


        String jwt = Jwts.builder()
                .setHeaderParam("alg",HS256)
                .setHeaderParam("type","jwt")
                .setClaims(claims)
                .signWith(HS256,"secret")
                .compact();

        System.out.println(jwt);
    }
}
