package com.mekhyua.vuele.uitls;


import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @Author: wzr
 * @Date: 2021/10/28 0028 13:55
 * @Description:
 **/
public class JwtUtil {
    private static long time  = 1000*60*60*24;
    private  static String signature = "admin";

    public static String createToken(String username){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .claim(username,"admin")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return  jwtToken;
    }

    public  static  boolean checkToken(String token){
        if (token == null){
            return false;
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return  false;
        }
        return  true;

    }
}
