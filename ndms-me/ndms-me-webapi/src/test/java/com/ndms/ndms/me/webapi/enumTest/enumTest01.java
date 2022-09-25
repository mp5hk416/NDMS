package com.ndms.ndms.me.webapi.enumTest;

import com.ndms.ndms.commons.restful.ResponseState;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Hi 俊翔
 * 現在是下午 12:37 2022/9/21 2022
 * 好好加油吧。
 * 不能再浪費時間了
 * 規劃自己，超越自己
 */
@SpringBootTest
@Slf4j
public class enumTest01 {

    @Test
    public void EnumTestWithParameter(){
        ResponseState responseState = ResponseState.valueOf("OK");//=OK
        Integer ok = ResponseState.valueOf("OK").getCode();//2000
        System.out.println(responseState);
        log.trace("ok對應碼:{}", responseState);
        System.out.println(ok);
        log.trace("ok對應碼:{}",ok);
    }

}
