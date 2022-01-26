package com.apirest.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Playlist {

	@Id
	private String id;
	private String name;
	
	public Playlist(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
