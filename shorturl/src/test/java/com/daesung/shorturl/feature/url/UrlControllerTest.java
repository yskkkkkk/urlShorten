package com.daesung.shorturl.feature.url;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebMvcTest(UrlController.class)
@AutoConfigureMockMvc
class UrlControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(UrlControllerTest.class);

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockMvc mock;

	@MockBean
	private UrlService urlService;

	@Before
	public void beforeTest() {
		logger.info("===== beforeTest() =====");
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
		logger.info("wac: " + wac);
		logger.info("mock: " + mock);
	}

	@Test
	public void testTest() throws Exception {
		logger.info("===== testTest() =====");

		mock.perform(get("/url/hello")).andExpect(status().isOk()).andExpect(content().string("hello"));
	}

	@After
	public void afterTest() {
		logger.info("===== afterTest() =====");
	}

	@Test
	void testInsOriginUrl() throws Exception {
		mock.perform(post("/url/url").content("https://knowing-today.blogspot.com/")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void testGetUrlInfo() throws Exception {
		MultiValueMap<String, String> urlDTO = new LinkedMultiValueMap<>();

		urlDTO.add("urlKey", "cc");
		mock.perform(get("/url/url").params(urlDTO)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("https://www.naver.com"));
	}

}
