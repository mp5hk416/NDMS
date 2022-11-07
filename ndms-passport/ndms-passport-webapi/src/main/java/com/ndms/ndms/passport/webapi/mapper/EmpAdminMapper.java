package com.ndms.ndms.passport.webapi.mapper;

import com.ndms.ndms.pojo.ams.emp.ams_DTO.EmpRegisterDTO;
import com.ndms.ndms.passport.webapi.pojo.empVO.EmpLoginVO;
import com.ndms.ndms.pojo.ams.emp.ams_DO.EmpAdminDO;
import com.ndms.ndms.pojo.ams.emp.ams_VO.EmpAdminVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpAdminMapper {

    EmpLoginVO getLoginEmpByUsername(String username);

    void empRegister(EmpRegisterDTO empRegisterDTO);

    int addAdmin(EmpAdminDO empAdminDO);

    int countById(Long id);

    int countByUsername(String username);

    EmpAdminVO getByUsername(String username);

    EmpAdminDO getByEmpNumber(String empNumber);

    List<EmpAdminVO> listAllMeAdmin();
}
