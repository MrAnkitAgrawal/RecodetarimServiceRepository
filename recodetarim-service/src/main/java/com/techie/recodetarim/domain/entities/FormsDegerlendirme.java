package com.techie.recodetarim.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formsdegerlendirme")
public class FormsDegerlendirme implements Serializable {
	private static final long serialVersionUID = 5208448832534736711L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "forms_detay_id")
	private Long formsDetayId;

	@Column(name = "deger")
	private String deger;

	@Column(name = "genel_id")
	private Long genelId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFormsDetayId() {
		return formsDetayId;
	}

	public void setFormsDetayId(Long formsDetayId) {
		this.formsDetayId = formsDetayId;
	}

	public String getDeger() {
		return deger;
	}

	public void setDeger(String deger) {
		this.deger = deger;
	}

	public Long getGenelId() {
		return genelId;
	}

	public void setGenelId(Long genelId) {
		this.genelId = genelId;
	}

	@Override
	public String toString() {
		return "FormsDegerlendirme [id=" + id + ", formsDetayId=" + formsDetayId + ", deger=" + deger + ", genelId="
				+ genelId + "]";
	}
}
