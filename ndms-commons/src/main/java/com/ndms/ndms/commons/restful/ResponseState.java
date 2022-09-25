package com.ndms.ndms.commons.restful;

import org.springframework.stereotype.Component;

/**
 * Hi 俊翔
 * 現在是上午 02:19 2022/9/19 2022
 * 好好加油吧。
 * 不能再浪費時間了
 * 規劃自己，超越自己
 */
@Component
public enum ResponseState {

    OK(2000),
    BAD_REQUEST(4000),
    UNAUTHORIZED(4001),
    FORBIDDEN(4003),
    NOT_FOUND(4004),
    METHOD_NOT_ALLOWED(4005),
    NOT_ACCEPTABLE(4006),
    CONFLICT(4009),
    REQUEST_GONE(4010),
    INNER_ERROR(5000);



    private Integer code;

    ResponseState(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
