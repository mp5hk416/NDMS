package com.ndms.ndms.passport.webapi.PassWordTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 時間:2022/10/15  上午 08:44
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@SpringBootTest
@Slf4j
public class PassWordTest {

    @Test
    public void BCryptCreate(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "mp5hk416";
        String newPassword = passwordEncoder.encode(password);
        log.debug("加密後:{}結束",newPassword);

//        int a = 1;
//        int b = 2;
//        int s = a+b;
//        System.out.println(s);
    }

//    @Test
//    public void parsePassword(){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    }


}
