package com.techie.recodetarim.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "formsdegerlendirmegenel")
public class FormsDegerlendirmeGenel implements Serializable {
	private static final long serialVersionUID = -8719108203745746648L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@Column(name = "fis_no")
	private Long fisNo;

	@Column(name = "form_no")
	private Long formNo;

	@Column(name = "yururluluk_tarihi")
	private LocalDate yururlulukTarihi;

	@Column(name = "revize_no_tarih")
	private LocalDate revizeNoTarih;

	@Column(name = "adi_soyadi")
	private String adiSoyadi;

	@Column(name = "adres")
	private String adres;

	@Column(name = "faaliyet_adresi")
	private String faaliyetAdresi;

	@Column(name = "kapsam_alt_kapsam")
	private String kapsamAltKapsam;

	@Column(name = "kontrolor")
	private String kontrolor;

	@Column(name = "proje")
	private String proje;

	@Column(name = "kontrol_tarihi")
	private LocalDate kontrolTarihi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFisNo() {
		return fisNo;
	}

	public void setFisNo(Long fisNo) {
		this.fisNo = fisNo;
	}

	public Long getFormNo() {
		return formNo;
	}

	public void setFormNo(Long formNo) {
		this.formNo = formNo;
	}

	public LocalDate getYururlulukTarihi() {
		return yururlulukTarihi;
	}

	public void setYururlulukTarihi(LocalDate yururlulukTarihi) {
		this.yururlulukTarihi = yururlulukTarihi;
	}

	public LocalDate getRevizeNoTarih() {
		return revizeNoTarih;
	}

	public void setRevizeNoTarih(LocalDate revizeNoTarih) {
		this.revizeNoTarih = revizeNoTarih;
	}

	public String getAdiSoyadi() {
		return adiSoyadi;
	}

	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getFaaliyetAdresi() {
		return faaliyetAdresi;
	}

	public void setFaaliyetAdresi(String faaliyetAdresi) {
		this.faaliyetAdresi = faaliyetAdresi;
	}

	public String getKapsamAltKapsam() {
		return kapsamAltKapsam;
	}

	public void setKapsamAltKapsam(String kapsamAltKapsam) {
		this.kapsamAltKapsam = kapsamAltKapsam;
	}

	public String getKontrolor() {
		return kontrolor;
	}

	public void setKontrolor(String kontrolor) {
		this.kontrolor = kontrolor;
	}

	public String getProje() {
		return proje;
	}

	public void setProje(String proje) {
		this.proje = proje;
	}

	public LocalDate getKontrolTarihi() {
		return kontrolTarihi;
	}

	public void setKontrolTarihi(LocalDate kontrolTarihi) {
		this.kontrolTarihi = kontrolTarihi;
	}

	@Override
	public String toString() {
		return "FormsDegerlendirmeGenel [id=" + id + ", fisNo=" + fisNo + ", formNo=" + formNo + ", yururlulukTarihi="
				+ yururlulukTarihi + ", revizeNoTarih=" + revizeNoTarih + ", adiSoyadi=" + adiSoyadi + ", adres="
				+ adres + ", faaliyetAdresi=" + faaliyetAdresi + ", kapsamAltKapsam=" + kapsamAltKapsam + ", kontrolor="
				+ kontrolor + ", proje=" + proje + ", kontrolTarihi=" + kontrolTarihi + "]";
	}
}
