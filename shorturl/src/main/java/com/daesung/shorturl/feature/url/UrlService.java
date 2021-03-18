package com.daesung.shorturl.feature.url;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlService {

	private final UrlDAO urlDAO;

	@Value("${config.base62.character}")
	private String character;
	
	@Transactional
	public String createUrlKey(UrlDTO urlDTO) { // inpit value: originUrl
		String result = "";
		if (urlDAO.getUrlInfo(urlDTO) == null) {
			urlDAO.createUrlKey(urlDTO);
			String key = stringToKeyOnBase62(173*urlDTO.getUrlSequence());
			if(key.length() > 8) 
				key = key.substring(0, 7);
			urlDTO.setUrlKey(key);
			urlDAO.setUrlKey(urlDTO);
			result = key;
		} else {
			result = urlDAO.getUrlInfo(urlDTO).getUrlKey();
		}
		
		return result;
	}

	public String getUrlInfo(UrlDTO urlDTO) { // inpit value: urlKey
		UrlDTO getDTO = urlDAO.getUrlInfo(urlDTO);
		getDTO.setRequestCount(getDTO.getRequestCount()+1);
		urlDAO.setUrlCount(getDTO);
		
		return getDTO.getOriginUrl();
	}

	private String stringToKeyOnBase62(int originUrl) {
		int cardinalNum = 62;
		List<Character> output = new ArrayList<>();
		while (originUrl != 0) {
			output.add(character.charAt(originUrl % cardinalNum)); // 나머지가 저장됨
			originUrl /= cardinalNum;
		}
		Collections.reverse(output);
		String key = output.toString().substring(1, 3 * output.size() - 1).replaceAll(", ", "");

		return key;
	}

}
