package com.ndms.ndms.passport.webapi.pojo.empVO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 時間:2022/10/15  上午 08:26
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Data
public class EmpLoginVO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String empNumber;
    private Integer enable;
    private String roleName;
    //注意跟資料庫類型必須相同，資料庫是varchar，這裡的mapper也必須是string，反映回來的自然也是String
    //而非EmpAuthority
    private List<String> authorities;

}
