package com.daesung.shorturl.feature.url;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("url")
@RequiredArgsConstructor
@Api(value = "url")
public class UrlController {

	private final UrlService urlService;
	
	@ApiOperation(value = "createUrlKey", notes = "입력")
	@PostMapping("url")
	public ResponseEntity<?> createUrlKey(@RequestBody UrlDTO urlDTO){
		log.info("input data: "+urlDTO.toString());
		String result = "";
		HttpStatus resultStatus = HttpStatus.OK;
		try {
			result = urlService.createUrlKey(urlDTO);
		} catch (Exception e) {
			e.printStackTrace();
			resultStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}finally {
			log.info(result);
		}
		return new ResponseEntity<>(result, resultStatus);
	}
	
	@ApiOperation(value = "getUrlInfo", notes = "입력")
	@GetMapping("url")
	public String getUrlInfo(@RequestParam String urlKey){
		log.info("input data: "+urlKey.toString());
		UrlDTO urlDTO = new UrlDTO();
		urlDTO.setUrlKey(urlKey);
		return urlService.getUrlInfo(urlDTO);
	}
	
	@GetMapping("hello")
	public String hello() {
		log.info("for test");
		return "hello";
	}
	
}
