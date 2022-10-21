package com.ndms.ndms.passport.webapi.mapper;


import com.ndms.ndms.pojo.ams.me_ams.ams_DO.MeAdminDO;
import com.ndms.ndms.pojo.ams.me_ams.ams_VO.MeAdminVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeEmpMapper {

    int addAdmin(MeAdminDO meAdminDO);

    int countById(Long id);

    int countByUsername(String username);

    MeAdminDO getByUsername(String username);

    List<MeAdminVO> listAllMeAdmin();





}
