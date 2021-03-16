package com.daesung.shorturl.feature.url;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.daesung.shorturl.model.dto.UrlDTO;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("url")
@RequiredArgsConstructor
@Api(value = "SwaggerTestController")
public class UrlController {

	private final UrlService urlService;
	
	@ApiOperation(value = "insOriginUrl", notes = "입력")
	@PostMapping("url")
	public ResponseEntity<?> insOriginUrl(@RequestBody UrlDTO urlDTO){
		String result = "";
		HttpStatus resultStatus = HttpStatus.OK;
		try {
			result = urlService.insOriginUrl(urlDTO);
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
		UrlDTO urlDTO = new UrlDTO();
		urlDTO.setUrl_key(urlKey);
		return urlService.getUrlInfo(urlDTO);
	}
}
