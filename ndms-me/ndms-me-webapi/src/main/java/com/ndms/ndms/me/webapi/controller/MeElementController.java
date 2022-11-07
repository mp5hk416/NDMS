package com.ndms.ndms.me.webapi.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.ndms.ndms.commons.restful.JsonResult;
import com.ndms.ndms.me.service.MeElementService;
import com.ndms.ndms.pojo.me.me_DTO.MeElementDTO;
import com.ndms.ndms.pojo.me.me_VO.MeElementVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('/meElement/list') AND hasAuthority('/meElement/add') AND hasAnyAuthority('/meElement/delete') AND hasAnyAuthority('/meElement/update')")
    public JsonResult getAll(){
        List<MeElementVO> allMeElement = meElementService.getAllMeElement();
        return JsonResult.ok(allMeElement);
    }

    @GetMapping("/get/{uploaderId}")
    @ApiOperation("藉uploaderid查詢機構")
    @ApiOperationSupport(order=101)
    @PreAuthorize("hasAnyAuthority('/meElement/list')")
    public JsonResult getByUploaderId(@PathVariable Long uploaderId){
        List<MeElementVO> meElements = meElementService.getMeElementByUploaderId(uploaderId);
        return JsonResult.ok(meElements);
    }

    @PostMapping("/addnew")
    @ApiOperation("新增機構組件")
    @ApiOperationSupport(order = 200)
    @PreAuthorize("hasAuthority('/meElement/add')")
    public JsonResult addMeElement(MeElementDTO meElementDTO){
        meElementService.addMeElement(meElementDTO);
        return JsonResult.ok("添加成功");
    }

    @PostMapping("/deleteByIds")
    @ApiOperation("刪除機構組件")
    @ApiOperationSupport(order = 300)
    @PreAuthorize("hasAuthority('/meElement/delete')")
    public JsonResult deleteByIds(Long... ids){
        meElementService.deleteMeElementByIds(ids);
        return JsonResult.ok("刪除成功");
    }

    @PostMapping("/update")
    @ApiOperation("更新機構組件")
    @ApiOperationSupport(order = 400)
    @PreAuthorize("hasAuthority('/meElement/update')")
    public JsonResult updateMeElement(MeElementDTO meElementDTO){
        meElementService.updateState(meElementDTO);
        return JsonResult.ok("更新成功");
    }










}
