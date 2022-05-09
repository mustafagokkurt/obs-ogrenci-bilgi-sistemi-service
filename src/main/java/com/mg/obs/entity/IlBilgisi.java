package com.mg.obs.entity;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "IlBilgisi")
@DynamicUpdate
@Data
public class IlBilgisi {
	@Id
	private int id;	
    

    private int Kod;
    private int MernisKodu;
    private String Aciklama;
    private List<IlceBilgisi> IlceBilgisi;
}