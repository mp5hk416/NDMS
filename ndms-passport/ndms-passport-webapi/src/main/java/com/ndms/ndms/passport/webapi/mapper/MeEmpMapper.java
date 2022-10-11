package com.ndms.ndms.passport.webapi.mapper;


import com.ndms.ndms.pojo.ams.me_ams.ams_DO.MeAdminDO;
import com.ndms.ndms.pojo.ams.me_ams.ams_DTO.MeAdminAddDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface MeEmpMapper {

    int addAdmin(MeAdminDO meAdminDO);

    int countById(Long id);

    int countByUsername(String username);



}
