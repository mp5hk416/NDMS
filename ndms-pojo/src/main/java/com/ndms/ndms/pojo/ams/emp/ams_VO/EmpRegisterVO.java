package com.ndms.ndms.pojo.ams.emp.ams_VO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 時間:2022/10/30  上午 09:19
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Data
public class EmpRegisterVO {

    private Long id;
    private String username;
    private String empNumber;
    private String password;
    private Long depIdd;
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
