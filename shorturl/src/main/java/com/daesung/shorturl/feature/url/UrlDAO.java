package com.daesung.shorturl.feature.url;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UrlDAO {

	// originUrl 입력받고 있는 지 확인
	// urlKey 입력받고 originUrl 반환하기  
	UrlDTO getUrlInfo(UrlDTO urlDTO);
	
	// 없으면 insert 해서 sq 를 받기
	void createUrlKey(UrlDTO urlDTO);
	
	// sq(일련번호이용해서 key 만들고 넣기) mod
	void setUrlKey(UrlDTO urlDTO);
	
	// 요청 수 count
	void setUrlCount(UrlDTO urlDTO);
}

