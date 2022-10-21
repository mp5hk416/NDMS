package com.ndms.ndms.pojo.me.me_VO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Hi 俊翔
 * 現在是下午 02:39 2022/9/19 2022
 * 好好加油吧。
 * 不能再浪費時間了
 * 規劃自己，超越自己
 */
@Data
public class MeElementVO implements Serializable {

    private Long id;
    private String partName;
    private String partNumber;
    private Integer attributionId;
    private String uploader;
    private Long uploaderId;
    private String description;
    private String url2d;
    private String url3d;
    private String manufacture;
    private Long manufactureId;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
