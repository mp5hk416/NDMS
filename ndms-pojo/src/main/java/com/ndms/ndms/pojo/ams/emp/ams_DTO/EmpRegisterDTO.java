package com.ndms.ndms.pojo.ams.emp.ams_DTO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 時間:2022/10/30  上午 09:24
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Data
public class EmpRegisterDTO {

    private Long id;
    private String username;
    private String empNumber;
    private String password;
    private Long depId;
    private String mail;
    private String cellPhone;
    private Integer enable;
    private Integer locked;
    private String lastLoginIp;
    private Integer loginCount;
    private LocalDateTime gmtLastLogin;
    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;
    private Integer department;
}
