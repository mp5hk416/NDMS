package com.ndms.ndms.me.webapi.mapper;

import com.ndms.ndms.pojo.me.me_do.MeElementEntity;
import com.ndms.ndms.pojo.me.me_dto.MeElementDTO;
import com.ndms.ndms.pojo.me.me_vo.MeElementVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeElementMapper {

    List<MeElementVO> list();

    List<MeElementVO> listByUploaderId(Long uploaderId);

    int countByUploaderId(Long uploaderId);

    int addMeElement(MeElementEntity meElementEntity);

    int deleteMeElementByIds(Long... id);

    int deleteMeElementByUploaderIds(Long... uploaderId);

    int countByPartNumber(String partNumber);

    int countById(Long id);

    void updateMeElementById(MeElementEntity meElementEntity);

    MeElementVO getById(Long id);

}
