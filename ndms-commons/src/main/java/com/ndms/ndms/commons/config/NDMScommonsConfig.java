package com.ndms.ndms.commons.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 時間:2022/10/18  下午 05:12
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Configuration
@ComponentScan({
        "com.ndms.ndms.commons.utils",
        "com.ndms.ndms.commons.exception.GlobalExceptionHandler"
})
public class NDMScommonsConfig {


}
