package com.ndms.ndms.passport.webapi.impl;

import com.alibaba.fastjson.JSON;
import com.ndms.ndms.commons.exception.NDMSException;
import com.ndms.ndms.commons.pojo.NDMSLoginDTO;
import com.ndms.ndms.commons.restful.ResponseState;
import com.ndms.ndms.commons.utils.JwtUtils;
import com.ndms.ndms.passport.service.EmpLoginService;
import com.ndms.ndms.passport.webapi.pojo.empVO.EmpInfoDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 時間:2022/10/18  下午 07:50
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Service
@Slf4j
public class EmpLoginServiceImpl implements EmpLoginService {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;




    @Override
    public String login(NDMSLoginDTO ndmsLoginDTO) {

        log.info("接收參數:名稱:{}，密碼:{}", ndmsLoginDTO.getUsername(), ndmsLoginDTO.getPassword());
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(ndmsLoginDTO.getUsername(), ndmsLoginDTO.getPassword());
        Authentication afterMangerAuthentication = authenticationManager.authenticate(authenticationToken);

        log.info("較驗後結果:{}", afterMangerAuthentication);
        log.info("較驗後核心資訊:{}", afterMangerAuthentication.getPrincipal());

        EmpInfoDetail empInfoDetail = (EmpInfoDetail) afterMangerAuthentication.getPrincipal();
        log.info("員工資訊:{}", empInfoDetail.toString());

        Long id = empInfoDetail.getId();
        log.info("id值:{}", id);
        String username = empInfoDetail.getUsername();
        log.info("使用者名稱:{}", username);
        Collection<GrantedAuthority> authorities = empInfoDetail.getAuthorities();
        log.info("權限值:{}", authorities);
        String empNumber = empInfoDetail.getEmpNumber();
        log.info("員工編號:{}", empNumber);
        String roleName = empInfoDetail.getRoleName();
        log.info("員工title:{}", roleName);

        if (!empInfoDetail.isEnabled()) {
            throw new NDMSException(ResponseState.FORBIDDEN, "該帳戶未啟用");
        }

        String JsonAuthorities = JSON.toJSONString(authorities);
        log.info("Json權限值:{}", JsonAuthorities);

        Map<String, Object> claims = new HashMap<>();

        claims.put("id", id);
        claims.put("username", username);
        claims.put("authorities", JsonAuthorities);
        log.info("claims:{}", claims.get("authorities"));
        claims.put("empNumber", empNumber);
        claims.put("roleName", roleName);


        return jwtUtils.generateToken(claims);

    }



}
