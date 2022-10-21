package com.ndms.ndms.passport.webapi.pojo.empVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 時間:2022/10/15  上午 09:15
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */
@Data
@ApiModel(value = "Token模板")
public class JwtVO implements Serializable {

    @ApiModelProperty(value="token值")
    private String tokenValue;

    @ApiModelProperty(value = "token頭名稱",example = "NDMS")
    private String tokenHeadName;
}
