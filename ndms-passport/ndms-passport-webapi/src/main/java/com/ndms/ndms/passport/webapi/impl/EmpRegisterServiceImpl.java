package com.ndms.ndms.passport.webapi.impl;

import com.ndms.ndms.commons.exception.NDMSException;
import com.ndms.ndms.commons.restful.ResponseState;
import com.ndms.ndms.passport.service.EmpRegisterService;
import com.ndms.ndms.passport.webapi.mapper.EmpAdminMapper;
import com.ndms.ndms.pojo.ams.emp.ams_DO.EmpAdminDO;
import com.ndms.ndms.pojo.ams.emp.ams_DTO.EmpRegisterDTO;
import com.ndms.ndms.pojo.ams.emp.ams_VO.EmpAdminVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 時間:2022/10/30  上午 09:14
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Service
@Slf4j
public class EmpRegisterServiceImpl implements EmpRegisterService {

    @Autowired
    private EmpAdminMapper empAdminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(EmpRegisterDTO empRegisterDTO) {

        EmpAdminDO empAdminDO = empAdminMapper.getByEmpNumber(empRegisterDTO.getEmpNumber());
        if (empAdminDO==null){
            String password = empRegisterDTO.getPassword();
            String encodedPassword = passwordEncoder.encode(password);

            BeanUtils.copyProperties(empRegisterDTO,empAdminDO);
            empAdminDO.setPassword(encodedPassword);
            empAdminMapper.addAdmin(empAdminDO);
        }
            throw new NDMSException(ResponseState.CONFLICT,"該用戶已存在");
    }
}
