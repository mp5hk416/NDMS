package com.ndms.ndms.me.service;

import com.ndms.ndms.pojo.me.me_DTO.MeElementDTO;
import com.ndms.ndms.pojo.me.me_VO.MeElementVO;

import java.util.List;

public interface MeElementService {

    List<MeElementVO> getAllMeElement();

    List<MeElementVO> getMeElementByUploaderId(Long uploaderId);

    void addMeElement(MeElementDTO meElementDTO);

    void deleteMeElementByIds(Long... id);

    void deleteMeElementByUploaderIds(Long... uploaderId);

    void updateState(MeElementDTO meElementDTO);



}
