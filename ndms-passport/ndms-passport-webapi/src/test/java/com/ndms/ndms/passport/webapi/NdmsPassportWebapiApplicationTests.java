package com.ndms.ndms.passport.webapi;

import com.ndms.ndms.commons.config.NDMScommonsConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({NDMScommonsConfig.class})
class NdmsPassportWebapiApplicationTests {

    @Test
    void contextLoads() {
    }

}
