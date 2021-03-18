package com.daesung.shorturl.feature.url;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlService {

	private final UrlDAO urlDAO;

	@Transactional
	public String createUrlKey(UrlDTO urlDTO) { // inpit value: originUrl
		if (urlDAO.getUrlInfo(urlDTO) == null) {
			urlDAO.createUrlKey(urlDTO);
			String key = stringToKeyOnBase62(173*urlDTO.getUrlSequence());
			if(key.length() > 8) key = key.substring(0, 7);
			urlDTO.setUrlKey(key);
			urlDAO.setUrlKey(urlDTO);
			return key;
		} else {
			return urlDAO.getUrlInfo(urlDTO).getUrlKey();
		}
	}

	public String getUrlInfo(UrlDTO urlDTO) { // inpit value: urlKey
		
		UrlDTO getDTO = urlDAO.getUrlInfo(urlDTO);
		getDTO.setRequestCount(getDTO.getRequestCount()+1);
		urlDAO.setUrlCount(getDTO);
		
		return getDTO.getOriginUrl();
	}

	public String stringToKeyOnBase62(int originUrl) {

		int cardinalNum = 62;
		String character = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
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
