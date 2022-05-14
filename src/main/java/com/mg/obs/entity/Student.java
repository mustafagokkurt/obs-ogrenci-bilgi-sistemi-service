package com.mg.obs.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Document(collection = "Student")
@DynamicUpdate
@Data
@AllArgsConstructor
@ToString(includeFieldNames=true)
public class Student {

	@Transient
    public static final String SEQUENCE_NAME = "Student";
	
	@Id
	private int id;
	
	@Field("Tckn")
	private String Tckn;
	
	@Field("Adi")
	private String Adi;
	
	@Field("Soyadi")
	private String Soyadi;
	
	@Field("Sehir")
	private int Sehir;
	
	@Field("Ilce")
	private int Ilce;
	
	@Field("Telefon")
	private String Telefon;
}
