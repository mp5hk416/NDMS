package com.ndms.ndms.commons.exception;

import com.ndms.ndms.commons.restful.ResponseState;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Hi 俊翔
 * 現在是上午 01:37 2022/9/19 2022
 * 好好加油吧。
 * 不能再浪費時間了
 * 規劃自己，超越自己
 */
@Data
public class NDMSException extends RuntimeException{

    private ResponseState responseState;

    public NDMSException(ResponseState responseState, String message) {
        super(message);
        setResponseState(responseState);
    }


}
