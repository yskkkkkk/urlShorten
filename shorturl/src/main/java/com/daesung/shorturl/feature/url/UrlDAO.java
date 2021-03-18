package com.daesung.shorturl.feature.url;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UrlDAO {

	UrlDTO getUrlInfo(UrlDTO urlDTO);
	
	void createUrlKey(UrlDTO urlDTO);
	
	void setUrlKey(UrlDTO urlDTO);
	
	void setUrlCount(UrlDTO urlDTO);
}

