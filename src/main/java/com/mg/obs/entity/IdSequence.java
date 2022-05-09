package com.mg.obs.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="IDSequence")
@Data
public class IdSequence {

	@Id
	private String id;
	
	private int seq;	
}
