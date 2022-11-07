package com.ndms.ndms.passport.service;

import com.ndms.ndms.pojo.ams.emp.ams_DTO.EmpRegisterDTO;
import org.springframework.stereotype.Service;


public interface EmpRegisterService {

    void register(EmpRegisterDTO empRegisterDTO);

}
