package com.ndms.ndms.passport.webapi.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.ndms.ndms.commons.restful.JsonResult;
import com.ndms.ndms.passport.service.MeEmpService;
import com.ndms.ndms.pojo.ams.me_ams.ams_DTO.MeAdminAddDTO;
import com.ndms.ndms.pojo.ams.me_ams.ams_VO.MeAdminVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 時間:2022/10/12  上午 12:09
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@RestController
@RequestMapping("/meemp")
@Api(tags="新增管理員")
public class MeEmpController {

    @Autowired
    private MeEmpService meEmpService;


    @PostMapping("/add")
    @ApiOperation("新增機構管理員")
    @ApiOperationSupport(order = 100)
    public JsonResult addNewAdmin(MeAdminAddDTO meAdminAddDTO){
        meEmpService.addMeAdmin(meAdminAddDTO);
        return JsonResult.ok("新增成功");
    }

    @GetMapping("/getall")
    @ApiOperation("顯示所有機構管理員")
    @ApiOperationSupport(order = 200)
    public JsonResult getAllMeAdmin(){
        List<MeAdminVO> meAdmin = meEmpService.getMeAdmin();
        return JsonResult.ok(meAdmin);
    }





}
