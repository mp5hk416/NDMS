package com.ndms.ndms.passport.webapi.security.impl;

import com.ndms.ndms.commons.exception.NDMSException;
import com.ndms.ndms.commons.pojo.EmpAuthority;
import com.ndms.ndms.passport.webapi.mapper.EmpAdminMapper;
import com.ndms.ndms.passport.webapi.pojo.empVO.EmpLoginVO;
import com.ndms.ndms.passport.webapi.pojo.empVO.EmpInfoDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 時間:2022/10/14  上午 02:54
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Service
@Slf4j
public class EmpUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmpAdminMapper empAdminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmpLoginVO empLoginVO = null;
        try {
            empLoginVO = empAdminMapper.getLoginEmpByUsername(username);
            log.info("獲取對象:{}",empLoginVO.toString());
        } catch (NDMSException e) {
            throw new BadCredentialsException("員工名稱找不到，重新登入");
        }
        if (empLoginVO ==null)
            return null;

        if (empLoginVO.getEnable()!=1){
            throw new BadCredentialsException("無法使用的帳號");
        }
        List<String> authorities = empLoginVO.getAuthorities();
        List<EmpAuthority> empAuthorities = new ArrayList<>();
        for (String authority : authorities) {
            empAuthorities.add(new EmpAuthority(authority));
        }
        EmpInfoDetail empInfoDetail = new EmpInfoDetail(
                empLoginVO.getUsername(),
                empLoginVO.getPassword(),
                empLoginVO.getEnable() != 0,
                empAuthorities
        );
        empInfoDetail.setId(empLoginVO.getId());
        empInfoDetail.setEmpNumber(empLoginVO.getEmpNumber());
        empInfoDetail.setRoleName(empLoginVO.getRoleName());
        log.info("員工資訊:{}",empInfoDetail);

        return empInfoDetail;
    }
}
