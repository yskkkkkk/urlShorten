package com.daesung.shorturl.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
@AutoConfigureMockMvc	// 자동 mock bean 설정
class MainControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(MainControllerTest.class);

	@Autowired
	private MockMvc mock;

	@Before
	public void beforeTest() {
		logger.info("===== beforeTest() =====");
	}

	@After
	public void afterTest() {
		logger.info("===== afterTest() =====");
	}

	@Test
	void testMain() throws Exception {
		mock.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("index"));
	}

	@Test
	void testMainWithPath() throws Exception {
		mock.perform(get("/cc"))
				.andDo(print())
				.andDo(log())
				.andExpect(status().isOk())
				.andExpect(model().attribute("urlKey", "cc"));
	}

}