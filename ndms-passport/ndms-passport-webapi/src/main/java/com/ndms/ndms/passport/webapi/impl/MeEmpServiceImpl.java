package com.ndms.ndms.passport.webapi.impl;

import com.ndms.ndms.commons.exception.NDMSException;
import com.ndms.ndms.commons.restful.ResponseState;
import com.ndms.ndms.passport.service.MeEmpService;
import com.ndms.ndms.passport.webapi.mapper.MeEmpMapper;
import com.ndms.ndms.pojo.ams.me_ams.ams_DO.MeAdminDO;
import com.ndms.ndms.pojo.ams.me_ams.ams_DTO.MeAdminAddDTO;
import com.ndms.ndms.pojo.ams.me_ams.ams_VO.MeAdminVO;
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
public class MeEmpServiceImpl implements MeEmpService {

    @Autowired
    private MeEmpMapper meEmpMapper;



    @Override
    public void addMeAdmin(MeAdminAddDTO meAdminAddDTO) {

        MeAdminDO meAdminDO = new MeAdminDO();
        if (meAdminAddDTO.getUsername()==null)
            throw new NDMSException(ResponseState.BAD_REQUEST,"需要輸入用戶名稱");

        if (meEmpMapper.countByUsername(meAdminAddDTO.getUsername())==1){
            throw new NDMSException(ResponseState.NOT_FOUND,"使用者名稱已存在");
        }else{

            BeanUtils.copyProperties(meAdminAddDTO,meAdminDO);
            meAdminDO.setGmtCreated(LocalDateTime.now());
            meAdminDO.setEnable(1);
            meAdminDO.setLocked(0);
            meAdminDO.setLastLoginIp("127.0.0.1");
            if (meAdminDO.getGmtLastLogin()==null || meAdminDO.getGmtModified()==null){
                meAdminDO.setGmtLastLogin(LocalDateTime.now());
                meAdminDO.setGmtModified(LocalDateTime.now());
            }
        }

        meEmpMapper.addAdmin(meAdminDO);

    }

    @Override
    public List<MeAdminVO> getMeAdmin() {

        List<MeAdminVO> meAdminVOS = meEmpMapper.listAllMeAdmin();
        return meAdminVOS;
    }
}
