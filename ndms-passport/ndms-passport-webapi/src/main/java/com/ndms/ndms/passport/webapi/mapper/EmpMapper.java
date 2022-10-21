package com.ndms.ndms.passport.webapi.mapper;

import com.ndms.ndms.passport.webapi.pojo.empVO.EmpLoginVO;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpMapper {

    EmpLoginVO getMeEmpByUsername(String username);
}
