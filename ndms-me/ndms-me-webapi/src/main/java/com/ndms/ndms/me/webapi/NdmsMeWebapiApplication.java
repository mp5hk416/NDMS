package com.ndms.ndms.me.webapi;

import com.ndms.ndms.commons.config.NDMScommonsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({NDMScommonsConfig.class})
public class NdmsMeWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NdmsMeWebapiApplication.class, args);
    }

}
