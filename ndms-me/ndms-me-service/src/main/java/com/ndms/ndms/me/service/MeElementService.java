package com.ndms.ndms.me.service;

import com.ndms.ndms.pojo.me.me_dto.MeElementDTO;
import com.ndms.ndms.pojo.me.me_vo.MeElementVO;

import java.util.List;

public interface MeElementService {

    List<MeElementVO> getAllMeElement();

    List<MeElementVO> getMeElementByUploaderId(Long uploaderId);

    void addMeElement(MeElementDTO meElementDTO);

    void deleteMeElementByIds(Long... id);

    void deleteMeElementByUploaderIds(Long... uploaderId);

}
