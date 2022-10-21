package com.ndms.ndms.passport.webapi;

import com.ndms.ndms.commons.config.NDMScommonsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({NDMScommonsConfig.class})
public class NdmsPassportWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NdmsPassportWebapiApplication.class, args);
    }

}
