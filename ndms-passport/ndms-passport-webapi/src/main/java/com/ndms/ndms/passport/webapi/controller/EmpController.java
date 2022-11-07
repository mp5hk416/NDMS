package com.ndms.ndms.passport.webapi.controller;

import com.ndms.ndms.commons.pojo.NDMSLoginDTO;
import com.ndms.ndms.commons.restful.JsonResult;
import com.ndms.ndms.passport.service.EmpLoginService;
import com.ndms.ndms.passport.service.EmpLogoutService;
import com.ndms.ndms.passport.service.EmpRegisterService;
import com.ndms.ndms.passport.webapi.pojo.empDTO.EmpLoginDTO;
import com.ndms.ndms.passport.webapi.pojo.empVO.JwtVO;
import com.ndms.ndms.pojo.ams.emp.ams_DTO.EmpRegisterDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 時間:2022/10/19  上午 12:26
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@RestController
@RequestMapping("/emp")
@Api(tags="員工介面")
public class EmpController {

    @Autowired
    private EmpLoginService empLoginService;

    @Autowired
    private EmpRegisterService empRegisterService;

    @Autowired
    private EmpLogoutService empLogoutService;

    @Value("${jwt.tokenHeadName}")
    private String tokenHeadName;

    @PostMapping("/login")
    @ApiOperation("登入")
    public JsonResult login(EmpLoginDTO empLoginDTO){
        NDMSLoginDTO ndmsLoginDTO = new NDMSLoginDTO();
        JwtVO jwtVO = new JwtVO();
        BeanUtils.copyProperties(empLoginDTO, ndmsLoginDTO);
        String jjwt = empLoginService.login(ndmsLoginDTO);
        jwtVO.setTokenHeadName(tokenHeadName);
        jwtVO.setTokenValue(jjwt);
        return JsonResult.ok(jwtVO);
    }

    @PostMapping("/register")
    @ApiOperation("註冊")
    public JsonResult register(EmpRegisterDTO empRegisterDTO){
        empRegisterService.register(empRegisterDTO);
        return JsonResult.ok("註冊成功");
    }

    @PostMapping("/logout")
    @ApiOperation("登出")
    public JsonResult Logout(@RequestHeader(name = "Authorization") String tokenWithName){
        empLogoutService.Logout(tokenWithName);
        return JsonResult.ok("登出成功");
    }






}
