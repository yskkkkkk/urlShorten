package com.daesung.shorturl.feature.url;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.daesung.shorturl.model.dto.UrlDTO;

@Mapper
@Repository
public interface UrlDAO {

	// origin url 입력받고 있는 지 확인
	// url_key 입력받고 origin_url 반환하기  
	UrlDTO getUrlInfo(UrlDTO urlDTO);
	
	// 없으면 insert 해서 sq 를 받기
	void insOriginUrl(UrlDTO urlDTO);
	
	// sq(일련번호이용해서 key 만들고 넣기) mod
	void setUrlKey(UrlDTO urlDTO);
	
	// 요청 수 count
	void setUrlCnt(UrlDTO urlDTO);
}

