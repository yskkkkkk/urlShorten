package com.daesung.shorturl.feature.url;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@ToString
public class UrlDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int urlSequence;
	private String originUrl;
	private String urlKey;
	private int requestCount;
	private String registDate;
	
	public UrlDTO(int urlSequence, String originUrl, String urlKey, int requestCount, String registDate) {
		super();
		this.urlSequence = urlSequence;
		this.originUrl = originUrl;
		this.urlKey = urlKey;
		this.requestCount = requestCount;
		this.registDate = registDate;
	}
	
	public UrlDTO(String originUrl) {
		super();
		this.originUrl = originUrl;
	}

	public UrlDTO() {
		// TODO Auto-generated constructor stub
	}
	
}
