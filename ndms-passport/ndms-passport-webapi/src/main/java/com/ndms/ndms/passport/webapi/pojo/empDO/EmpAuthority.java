package com.ndms.ndms.passport.webapi.pojo.empDO;

import io.jsonwebtoken.lang.Assert;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * 時間:2022/10/15  上午 09:19
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Data
@NoArgsConstructor
public class EmpAuthority implements GrantedAuthority {

    private String authority;

    public EmpAuthority(String authority) {
        this.authority = authority;
    }
}
