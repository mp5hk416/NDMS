package com.ndms.ndms.passport.webapi.pojo.empDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 時間:2022/10/15  上午 08:27
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Data
@ApiModel(value="員工登陸DTO")
@NoArgsConstructor
public class EmpLoginDTO implements Serializable{

    @ApiModelProperty(value = "用戶名稱", name = "username", example = "Jackie", required = true)
    public String username;
    @ApiModelProperty(value = "用戶密碼", name = "password", example = "mp5hk416", required = true)
    public String password;
}
