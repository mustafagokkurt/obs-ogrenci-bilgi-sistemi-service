package com.mg.obs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

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
	@NotNull
	private String Tckn;
	
	@Field("Adi")
	@NotNull
	private String Adi;
	
	@Field("Soyadi")
	@NotNull
	private String Soyadi;
	
	@Field("Sehir")
	private int Sehir;
	
	@Field("Ilce")
	private int Ilce;
	
	@Field("Telefon")
	private String Telefon;
}
