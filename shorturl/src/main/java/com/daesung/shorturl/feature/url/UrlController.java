package com.daesung.shorturl.feature.url;

import org.springframework.web.bind.annotation.*;

import com.daesung.shorturl.model.dto.UrlDTO;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("url")
@RequiredArgsConstructor
@Api(value = "SwaggerTestController")
public class UrlController {

	private final UrlService urlService;
	
	@ApiOperation(value = "insOriginUrl", notes = "입력")
	@PostMapping("url")
	public String insOriginUrl(@RequestBody UrlDTO urlDTO){
		return urlService.insOriginUrl(urlDTO);
	}
	
	@ApiOperation(value = "getUrlInfo", notes = "입력")
	@GetMapping("url")
	public String getUrlInfo(@RequestParam String urlKey){
		UrlDTO urlDTO = new UrlDTO();
		urlDTO.setUrl_key(urlKey);
		return urlService.getUrlInfo(urlDTO);
	}
	
}
