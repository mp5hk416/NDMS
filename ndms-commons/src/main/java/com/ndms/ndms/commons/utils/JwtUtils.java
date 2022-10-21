package com.ndms.ndms.commons.utils;


import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

/**
 * 時間:2022/10/18  下午 04:06
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Component
@Slf4j
public class JwtUtils {

    private static final String JWT_DATE_CREATED = "NDMSTokenCreated";

    private JwtUtils(){}

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.tokenHeadName}")
    private String tokenName;

    
    public String generateToken(Map<String ,Object> claims){
        log.info("產生jwt");
        return Jwts.builder()
                .setHeaderParam("alg",HS256)
                .setHeaderParam("type","jwt")
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(HS256,secret)
                .compact();
    }

    private Date generateExpirationDate(){
        Date date = new Date(System.currentTimeMillis()+expiration*1000);
        log.info("生成過期時間:{}",date);
        return date;
    }

    public Claims getClaimsFromToken(String jwt){

        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            log.debug("jwt過期");
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            log.debug("jwt不支援");
        } catch (MalformedJwtException e) {
            e.printStackTrace();
            log.debug("jwt格式錯誤");
        } catch (SignatureException e) {
            e.printStackTrace();
            log.debug("jwt簽名錯誤");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            log.debug("jwt參數異常");
        }
        return claims;
    }


}
