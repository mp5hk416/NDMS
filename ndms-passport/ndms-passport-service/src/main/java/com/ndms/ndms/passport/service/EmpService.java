package com.ndms.ndms.passport.service;

import com.ndms.ndms.pojo.ams.emp.ams_DTO.EmpAdminAddDTO;
import com.ndms.ndms.pojo.ams.emp.ams_VO.EmpAdminVO;

import java.util.List;


public interface EmpService {

    void addMeAdmin(EmpAdminAddDTO empAdminAddDTO);

    List<EmpAdminVO> getAdmin();


}
