package com.ndms.ndms.passport.webapi.impl;

import com.ndms.ndms.commons.exception.NDMSException;
import com.ndms.ndms.commons.restful.ResponseState;
import com.ndms.ndms.passport.service.EmpService;
import com.ndms.ndms.passport.webapi.mapper.EmpAdminMapper;
import com.ndms.ndms.pojo.ams.emp.ams_DO.EmpAdminDO;
import com.ndms.ndms.pojo.ams.emp.ams_DTO.EmpAdminAddDTO;
import com.ndms.ndms.pojo.ams.emp.ams_VO.EmpAdminVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 時間:2022/10/11  下午 11:55
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpAdminMapper meEmpAdminMapper;



    @Override
    public void addMeAdmin(EmpAdminAddDTO empAdminAddDTO) {

        EmpAdminDO empAdminDO = new EmpAdminDO();
        if (empAdminAddDTO.getUsername()==null)
            throw new NDMSException(ResponseState.BAD_REQUEST,"需要輸入用戶名稱");

        if (meEmpAdminMapper.countByUsername(empAdminAddDTO.getUsername())==1){
            throw new NDMSException(ResponseState.NOT_FOUND,"使用者名稱已存在");
        }else{

            BeanUtils.copyProperties(empAdminAddDTO, empAdminDO);
            empAdminDO.setGmtCreated(LocalDateTime.now());
            empAdminDO.setEnable(1);
            empAdminDO.setLocked(0);
            empAdminDO.setLastLoginIp("127.0.0.1");
            if (empAdminDO.getGmtLastLogin()==null || empAdminDO.getGmtModified()==null){
                empAdminDO.setGmtLastLogin(LocalDateTime.now());
                empAdminDO.setGmtModified(LocalDateTime.now());
            }
        }

        meEmpAdminMapper.addAdmin(empAdminDO);

    }

    @Override
    public List<EmpAdminVO> getAdmin() {

        List<EmpAdminVO> meAdminVOS = meEmpAdminMapper.listAllMeAdmin();
        return meAdminVOS;
    }
}
