package com.ndms.ndms.passport.service;

import com.ndms.ndms.pojo.ams.me_ams.ams_DTO.MeAdminAddDTO;
import com.ndms.ndms.pojo.ams.me_ams.ams_VO.MeAdminVO;

import java.util.List;


public interface MeEmpService {

    void addMeAdmin(MeAdminAddDTO meAdminAddDTO);

    List<MeAdminVO> getMeAdmin();




}
