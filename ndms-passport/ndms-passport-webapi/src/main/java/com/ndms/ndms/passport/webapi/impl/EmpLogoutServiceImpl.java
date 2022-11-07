package com.ndms.ndms.passport.webapi.impl;

import com.ndms.ndms.commons.exception.NDMSException;
import com.ndms.ndms.commons.restful.ResponseState;
import com.ndms.ndms.passport.service.EmpLoginService;
import com.ndms.ndms.passport.service.EmpLogoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 時間:2022/11/6  上午 10:48
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Service
@Slf4j
public class EmpLogoutServiceImpl implements EmpLogoutService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${jwt.tokenHeadName}")
    private String HeadName;

    @Override
    public void Logout(String JwtWithName) {

        String redis_key = "redis_userInfo_key";

        if (JwtWithName != null && JwtWithName.startsWith(HeadName)) {
            String jwt = JwtWithName.substring(HeadName.length());
            stringRedisTemplate.boundSetOps(redis_key).add(jwt);
            Long add = stringRedisTemplate.boundSetOps(redis_key).add(jwt);
            if (add==0){
                throw new NDMSException(ResponseState.METHOD_NOT_ALLOWED,"已登出，重複登出");
            }

        }else {
            throw new NDMSException(ResponseState.NOT_FOUND,"沒有相應JWT在內");
        }

    }
}
