package com.ndms.ndms.pojo.ams.emp.ams_DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 時間:2022/10/11  下午 10:48
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Data
@ApiModel(value="新增管理員表用")
public class EmpAdminAddDTO {

    @ApiModelProperty(value = "管理員id",name = "id",example = "1", required = true, allowEmptyValue = true)
    private Long id;
    @ApiModelProperty(value = "管理員名稱",name = "username",example = "Jackie", required = true)
    private String username;
    @ApiModelProperty(value = "員工編號",name = "empNumber",example = "IEC070821", required = true)
    private String empNumber;
    @ApiModelProperty(value = "密碼",name = "password",example = "mp5hk416", required = true)
    private String password;
    @ApiModelProperty(value = "部門id",name = "depId",example = "1", required = true)
    private Long depId;
    @ApiModelProperty(value = "管理員信箱",name = "mail" ,example = "mp5hk41@gmail.com", required = true,allowEmptyValue = true)
    private String mail;
    @ApiModelProperty(value = "管理員手機",name = "cellPhone" ,example = "886912345678", required = true,allowEmptyValue = true)
    private String cellPhone;



}
