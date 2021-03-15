package com.daesung.shorturl.feature.url;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.daesung.shorturl.model.dto.UrlDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("url")
@RequiredArgsConstructor
public class UrlController {

	private final UrlService urlService;
	
	@PostMapping("url")
	public String insOriginUrl(@RequestBody UrlDTO urlDTO){
		return urlService.insOriginUrl(urlDTO);
	}
	
	@GetMapping("url")
	public String getUrlInfo(@RequestParam String urlKey){
		UrlDTO urlDTO = new UrlDTO();
		urlDTO.setUrl_key(urlKey);
		return urlService.getUrlInfo(urlDTO);
	}
	
}
