package com.daesung.shorturl.model.dto;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@ToString
public class UrlDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int url_sq;
	private String origin_url;
	private String url_key;
	private int request_cnt;
	private String reg_date;
	
	public UrlDTO(int url_sq, String origin_url, String url_key, int request_cnt, String reg_date) {
		super();
		this.url_sq = url_sq;
		this.origin_url = origin_url;
		this.url_key = url_key;
		this.request_cnt = request_cnt;
		this.reg_date = reg_date;
	}
	
	public UrlDTO(String origin_url) {
		super();
		this.origin_url = origin_url;
	}

	public UrlDTO() {
		// TODO Auto-generated constructor stub
	}
	
}
