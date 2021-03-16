package com.daesung.shorturl.feature.url;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebMvcTest(UrlController.class)
class UrlControllerTest {

	 private static final Logger logger = LoggerFactory.getLogger(UrlControllerTest.class);
	
	@Autowired // Dependency Injection(의존성 주입)
    private WebApplicationContext wac;
    private MockMvc mock;

    @Before
    public void beforeTest(){
        logger.info("===== beforeTest() =====");
        mock = MockMvcBuilders.webAppContextSetup(wac).build();
        logger.info("wac: " + wac);
        logger.info("mock: " + mock);
    }

    @Test
    public void testTest() throws Exception {
        logger.info("===== testTest() =====");
        
        mock.perform(get("/url/test"))
                .andExpect(status().isOk())
                .andExpect( (ResultMatcher) content().string("good"));
    }

    @After
    public void afterTest(){
        logger.info("===== afterTest() =====");
    }
	
	@Test
	void testInsOriginUrl() {
	}

	@Test
	void testGetUrlInfo() {
	}

}
