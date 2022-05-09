package com.mg.obs.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class IlceBilgisi {
	
	@Id
	public int RowIdentity;
	public int Kod;
	public String Aciklama;
	public int MernisKodu;	
}
