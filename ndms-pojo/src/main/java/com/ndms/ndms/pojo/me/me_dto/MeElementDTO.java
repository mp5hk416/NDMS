package com.ndms.ndms.pojo.me.me_dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Hi 俊翔
 * 現在是下午 02:38 2022/9/19 2022
 * 好好加油吧。
 * 不能再浪費時間了
 * 規劃自己，超越自己
 */
@Data
@ApiModel(value="機構件表用")
public class MeElementDTO {

    @ApiModelProperty(value = "機構件id",name = "id",example = "8", required = true,allowEmptyValue = true)
    private Long id;
    @ApiModelProperty(value = "機構件名稱",name = "partName",example = "new_screw", required = true)
    private String partName;
    @ApiModelProperty(value = "機構件料號",name = "partNumber",example = "6053B0009506", allowEmptyValue = true)
    private String partNumber;
    @ApiModelProperty(value = "機構件屬性id",name = "attributionId",example = "2", allowEmptyValue = true)
    private Integer attributionId;
    @ApiModelProperty(value = "機構件上傳者",name = "uploader",example = "Tom", required = true)
    private String uploader;
    @ApiModelProperty(value = "機構件上傳者id",name = "uploaderId",example = "6", allowEmptyValue = true)
    private Long uploaderId;
    @ApiModelProperty(value = "機構件敘述",name = "description",example = "新螺絲", allowEmptyValue = true)
    private String description;
    @ApiModelProperty(value = "2D圖",name = "url2d",example = "/2d_graph_9506.jpg", allowEmptyValue = true)
    private String url2d;
    @ApiModelProperty(value = "3D圖",name = "url3d",example = "/3d_graph_9506.prt", allowEmptyValue = true)
    private String url3d;
    @ApiModelProperty(value = "廠商",name = "manufacture",example = "巨寶", allowEmptyValue = true)
    private String manufacture;
    @ApiModelProperty(value = "廠商id",name = "manufactureId",example = "1", allowEmptyValue = true)
    private Long manufactureId;



}
