package com.daesung.shorturl.feature.url;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daesung.shorturl.model.dto.UrlDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlService {

	private final UrlDAO urlDAO;

	@Transactional
	public String insOriginUrl(UrlDTO urlDTO) { // inpit value: origin_url
		if (urlDAO.getUrlInfo(urlDTO) == null) {
			urlDAO.insOriginUrl(urlDTO);
			String key = toStringKeyOnBase62(173*urlDTO.getUrl_sq());
			if(key.length() > 8) key = key.substring(0, 7);
			urlDTO.setUrl_key(key);
			urlDAO.setUrlKey(urlDTO);
			return key;
		} else {
			return urlDAO.getUrlInfo(urlDTO).getUrl_key();
		}
	}

	public String getUrlInfo(UrlDTO urlDTO) { // inpit value: url_key
		
		UrlDTO getDTO = urlDAO.getUrlInfo(urlDTO);
		getDTO.setRequest_cnt(getDTO.getRequest_cnt()+1);
		urlDAO.setUrlCnt(getDTO);
		
		return getDTO.getOrigin_url();
	}

	public String toStringKeyOnBase62(int originUrl) {

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
