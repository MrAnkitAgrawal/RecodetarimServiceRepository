package com.techie.recodetarim.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parametre")
public class Parametre implements Serializable {
	private static final long serialVersionUID = 1801893653353937125L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "secenek")
	private String secenek;

	@Column(name = "deger")
	private String deger;

	public Parametre() {
	}

	public Parametre(String secenek, String deger) {
		this.secenek = secenek;
		this.deger = deger;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSecenek() {
		return secenek;
	}

	public void setSecenek(String secenek) {
		this.secenek = secenek;
	}

	public String getDeger() {
		return deger;
	}

	public void setDeger(String deger) {
		this.deger = deger;
	}

	@Override
	public String toString() {
		return "Parametre [id=" + id + ", secenek=" + secenek + ", deger=" + deger + "]";
	}
}
