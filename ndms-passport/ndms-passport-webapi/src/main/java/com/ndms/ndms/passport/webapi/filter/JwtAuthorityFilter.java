package com.ndms.ndms.passport.webapi.filter;

import com.alibaba.fastjson.JSON;
import com.ndms.ndms.commons.utils.JwtUtils;
import com.ndms.ndms.passport.webapi.pojo.empDO.EmpAuthority;
import com.ndms.ndms.passport.webapi.pojo.empVO.EmpInfoDetail;
import com.ndms.ndms.passport.webapi.security.pojo.LoginPinciple;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 時間:2022/10/18  下午 08:48
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Component
@Slf4j
public class JwtAuthorityFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String head;

    @Value("${jwt.tokenHeadName}")
    private String tokenHeadName;

    @Autowired(required = false)
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        log.info("執行Authority過濾器");

        String JwtWithName = httpServletRequest.getHeader(this.head);
        log.info("頭部信息:[}",JwtWithName);

        Claims claims = null;

        if (!StringUtils.hasText(JwtWithName)){
            //TODO redis 驗證用戶信息
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }

        if (JwtWithName!=null && JwtWithName.startsWith(tokenHeadName)){
            String authJwt = JwtWithName.substring(tokenHeadName.length());
            claims = jwtUtils.getClaimsFromToken(authJwt);

            Object id = claims.get("id");
            log.info("解析id:{}",id.toString());
            Object username = claims.get("username");
            log.info("解析員工名稱:{}",username.toString());
            Object authorities = claims.get("authorities");

            List<EmpAuthority> empAuthorities = JSON.parseArray(authorities.toString(), EmpAuthority.class);

            LoginPinciple loginPinciple = new LoginPinciple();
            loginPinciple.setId(Long.parseLong(id.toString()));
            loginPinciple.setUsername(username.toString());

            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginPinciple, null, empAuthorities);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authenticationToken);

            filterChain.doFilter(httpServletRequest,httpServletResponse);

        }


    }
}
