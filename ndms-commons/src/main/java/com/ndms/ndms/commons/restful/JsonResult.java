package com.ndms.ndms.commons.restful;

import com.ndms.ndms.commons.exception.NDMSException;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

/**
 * Hi 俊翔
 * 現在是上午 02:30 2022/9/19 2022
 * 好好加油吧。
 * 不能再浪費時間了
 * 規劃自己，超越自己
 */
@Data
public class JsonResult implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    public static JsonResult ok(){
        return ok(null);
    }

    public static JsonResult ok(String message){
        JsonResult result = new JsonResult();
        //枚舉類 valueOf()
        result.setCode(ResponseState.valueOf("OK").getCode());
        result.setMessage(message);
        return result;
    }

    public static JsonResult ok(Object data){
        JsonResult result = new JsonResult();
        result.setCode(ResponseState.OK.getCode());
        result.setData(data);
        return result;
    }

    public static JsonResult fail(ResponseState responseState, String message){
        JsonResult result = new JsonResult();
        result.setCode(responseState.getCode());
        result.setMessage(message);
        return result;
    }

    public static JsonResult fail(ResponseState responseState, Throwable e){
        return fail(responseState, e.getMessage());
    }

    public static JsonResult fail(NDMSException e){
        return fail(e.getResponseState(),e);
    }



}
