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
}
