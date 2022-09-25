package com.ndms.ndms.commons.restful;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

// 通用的支持分页查询返回的结果对象
@Data
public class JsonPage<T> implements Serializable {

    @ApiModelProperty(value = "當前頁碼",name="pageNum")
    private Integer pageNum;
    @ApiModelProperty(value = "每頁條數",name = "pageSize")
    private Integer pageSize;
    @ApiModelProperty(value = "總條數",name = "totalCount")
    private Long totalCount;
    @ApiModelProperty(value = "總頁數",name = "totalPages")
    private Integer totalPages;
    // 可以添加其他有必要的分页信息属性
    // 查询出的所有对象的集合
    @ApiModelProperty(value = "分頁數據",name = "list")
    private List<T> list;

    // 下面定义一个方法,实现将PageInfo类型中的对象的值赋值给当前JsonPage对象对应的属性
    // 相当于一个转换方法
    // 任何静态方法需要泛型类型声明都需要在static关键字和返回值之前声明一个<T>
    public static <T> com.ndms.ndms.commons.restful.JsonPage<T> restPage(PageInfo<T> pageInfo){
        com.ndms.ndms.commons.restful.JsonPage<T> result=new com.ndms.ndms.commons.restful.JsonPage<>();
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotalCount(pageInfo.getTotal());
        result.setTotalPages(pageInfo.getPages());
        // 将pageinfo中的查询结果结合也要赋值过去
        result.setList(pageInfo.getList());
        return  result;

    }




}
