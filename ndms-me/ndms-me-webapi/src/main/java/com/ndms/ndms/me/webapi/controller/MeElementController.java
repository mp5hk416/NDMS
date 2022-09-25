package com.ndms.ndms.me.webapi.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.ndms.ndms.commons.restful.JsonResult;
import com.ndms.ndms.me.service.MeElementService;
import com.ndms.ndms.pojo.me.me_dto.MeElementDTO;
import com.ndms.ndms.pojo.me.me_vo.MeElementVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Hi 俊翔
 * 現在是上午 12:50 2022/9/23 2022
 * 好好加油吧。
 * 不能再浪費時間了
 * 規劃自己，超越自己
 */
@RestController
@RequestMapping("/meelement")
@Api(tags = "1. 機構查詢模塊")
public class MeElementController {

    @Autowired
    MeElementService meElementService;

    @GetMapping("/getall")
    @ApiOperation("查詢機構")
    @ApiOperationSupport(order=100)
    public JsonResult getAll(){
        List<MeElementVO> allMeElement = meElementService.getAllMeElement();
        return JsonResult.ok(allMeElement);
    }

    @GetMapping("/get/{uploaderId}")
    @ApiOperation("藉uploaderid查詢機構")
    @ApiOperationSupport(order=101)
    public JsonResult getByUploaderId(@PathVariable Long uploaderId){
        List<MeElementVO> meElements = meElementService.getMeElementByUploaderId(uploaderId);
        return JsonResult.ok(meElements);
    }

    @PostMapping("/addnew")
    @ApiOperation("新增組件")
    @ApiOperationSupport(order = 200)
    public JsonResult addMeElement(MeElementDTO meElementDTO){
        meElementService.addMeElement(meElementDTO);
        return JsonResult.ok("添加成功");
    }









}
