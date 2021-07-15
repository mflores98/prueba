package com.xqd.sils.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
class MainTests {
    protected final Log logger = LogFactory.getLog(MainTests.class);

    @Test
    public void contextLoads() {
        logger.info("DKSA");
    }

}
