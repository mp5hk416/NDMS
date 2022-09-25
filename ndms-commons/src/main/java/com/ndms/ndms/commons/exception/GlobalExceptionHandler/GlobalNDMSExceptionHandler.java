package com.ndms.ndms.commons.exception.GlobalExceptionHandler;

import com.ndms.ndms.commons.exception.NDMSException;
import com.ndms.ndms.commons.restful.JsonResult;
import com.ndms.ndms.commons.restful.ResponseState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Hi 俊翔
 * 現在是上午 03:47 2022/9/19 2022
 * 好好加油吧。
 * 不能再浪費時間了
 * 規劃自己，超越自己
 */
@RestControllerAdvice
@Slf4j
public class GlobalNDMSExceptionHandler {

    @ExceptionHandler
    public JsonResult HandleNDMSException(NDMSException e){
        log.debug("統一處裡NDMS異常代號:{}，異常信息:{}",e.getMessage(),e.getResponseState());
        return JsonResult.fail(e);
    }

    @ExceptionHandler
    public JsonResult HandleOtherException(Throwable e){
        log.debug("統一處裡其他異常，異常信息:{}",e.getMessage());
        return JsonResult.fail(ResponseState.INNER_ERROR,e);
    }


}
