package com.ndms.ndms.me.webapi.impl;

import com.ndms.ndms.commons.exception.NDMSException;
import com.ndms.ndms.commons.restful.ResponseState;
import com.ndms.ndms.me.service.MeElementService;
import com.ndms.ndms.me.webapi.mapper.MeElementMapper;
import com.ndms.ndms.pojo.me.me_do.MeElementEntity;
import com.ndms.ndms.pojo.me.me_dto.MeElementDTO;
import com.ndms.ndms.pojo.me.me_vo.MeElementVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Hi 俊翔
 * 現在是下午 11:38 2022/9/22 2022
 * 好好加油吧。
 * 不能再浪費時間了
 * 規劃自己，超越自己
 */
@Service
@Slf4j
public class MeElementServiceImpl implements MeElementService {


    @Autowired
    MeElementMapper meElementMapper;


    @Override
    public List<MeElementVO> getAllMeElement() {

        List<MeElementVO> list = meElementMapper.list();

        return list;

    }

    @Override
    public List<MeElementVO> getMeElementByUploaderId(Long uploaderId) {

        int i = meElementMapper.countByUploaderId(uploaderId);

        if (i<=0){
            String message = "沒找到對應上傳者id";
            log.debug("數量:{}",i);
            log.error(message);
            throw new NDMSException(ResponseState.NOT_FOUND,message);
        }

        List<MeElementVO> meElementVOs = meElementMapper.listByUploaderId(uploaderId);

        return meElementVOs;
    }

    @Override
    public void addMeElement(MeElementDTO meElementDTO) {

        if (meElementMapper.countByPartNumber(meElementDTO.getPartNumber())>=1){
            throw new NDMSException(ResponseState.BAD_REQUEST,"料號重複");
        }
        if (meElementMapper.countById(meElementDTO.getId())>=1){
            meElementDTO.setId(null);
        }
        MeElementEntity meElementEntity = new MeElementEntity();
        BeanUtils.copyProperties(meElementDTO,meElementEntity);
        meElementEntity.setCreatedDate(LocalDateTime.now());
        meElementEntity.setUpdateDate(LocalDateTime.now());

        int rows = meElementMapper.addMeElement(meElementEntity);
        if (rows!=1){
            throw new NDMSException(ResponseState.BAD_REQUEST,"添加失敗，確認XML語法");
        }
    }

    @Override
    public void deleteMeElementByIds(Long... ids) {
        for (Long id : ids) {
            if (meElementMapper.countById(id)!=1)
                throw new NDMSException(ResponseState.NOT_FOUND,"相關Id找不到");
        }
        int rows = meElementMapper.deleteMeElementByIds(ids);
        if (rows<1)
            throw new NDMSException(ResponseState.BAD_REQUEST,"無法預知的錯誤");
    }

    @Override
    public void deleteMeElementByUploaderIds(Long...uploaderIds) {
        for (Long uploaderId : uploaderIds) {
            if (meElementMapper.countByUploaderId(uploaderId)<=0)
                throw new NDMSException(ResponseState.NOT_FOUND,"沒有相關上傳者ID");
        }
        int rows = meElementMapper.deleteMeElementByUploaderIds(uploaderIds);
        if (rows<1)
            throw new NDMSException(ResponseState.BAD_REQUEST,"無法預知的錯誤");

    }

    @Override
    public void updateState(MeElementDTO meElementDTO) {
        if (meElementMapper.getById(meElementDTO.getId())!=null){
            MeElementEntity meElementEntity = new MeElementEntity();
            BeanUtils.copyProperties(meElementDTO,meElementEntity);
            meElementEntity.setUpdateDate(LocalDateTime.now());
            meElementMapper.updateMeElementById(meElementEntity);
        }else
        throw new NDMSException(ResponseState.BAD_REQUEST,"沒有確認對應用戶");
    }
}
