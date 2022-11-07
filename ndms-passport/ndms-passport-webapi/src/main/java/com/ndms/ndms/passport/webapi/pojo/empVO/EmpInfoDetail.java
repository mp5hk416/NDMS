package com.ndms.ndms.passport.webapi.pojo.empVO;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 時間:2022/10/15  上午 09:15
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Setter
@Getter
@EqualsAndHashCode
@ToString(callSuper = true)
public class EmpInfoDetail extends User{

    private Long id;
    private String empNumber;
    private String roleName;

    public EmpInfoDetail(String username, String password, boolean enabled,  Collection<? extends GrantedAuthority> authorities){
        super(username, password, enabled, true, true, true, authorities);
    }


}
