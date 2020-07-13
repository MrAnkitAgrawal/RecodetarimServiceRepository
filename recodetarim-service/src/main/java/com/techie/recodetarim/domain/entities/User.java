package com.techie.recodetarim.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = -6843298414479704956L;

	@Id
	@Column(name = "id")
	@JsonIgnore
	private Long id;

	@Column(name = "kod")
	private String kod;

	@Column(name = "sifre")
	@JsonIgnore
	private String sifre;

	@Column(name = "ad")
	private String ad;

	@Column(name = "soyad")
	private String soyad;

	public User() {
	}

	public User(String kod, String sifre, String ad, String soyad) {
		this.kod = kod;
		this.sifre = sifre;
		this.ad = ad;
		this.soyad = soyad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", kod=" + kod + ", sifre=" + sifre + ", ad=" + ad + ", soyad=" + soyad + "]";
	}
}
