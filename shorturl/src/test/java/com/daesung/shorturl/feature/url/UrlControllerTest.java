package com.daesung.shorturl.feature.url;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UrlControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(UrlControllerTest.class);

	@Autowired
	private UrlService urlService;

	
	@Before
	public void beforeTest() {
		logger.info("===== beforeTest() =====");
	}

	@After
	public void afterTest() {
		logger.info("===== afterTest() =====");
	}

	@Test
	void testCreateUrlKey() {
		UrlDTO urlDTO = new UrlDTO("http://www.kakao.com");
		assertThat(urlService.createUrlKey(urlDTO)).isNotNull();
	}
	@Test
	void testGetUrlInfo() {
		UrlDTO urlDTO = new UrlDTO();
		urlDTO.setUrlKey("cc");
		assertThat(urlService.getUrlInfo(urlDTO)).isEqualTo("https://www.naver.com");
	}
}
