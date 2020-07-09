package com.techie.recodetarim.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "formsdegerlendirmeresim")
public class FormsDegerlendirmeResim implements Serializable {
	private static final long serialVersionUID = 8229396391042335659L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column(name = "signature", columnDefinition = "BLOB")
	private byte[] signature;

	@Column(name = "genel_id")
	private Long genelId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public Long getGenelId() {
		return genelId;
	}

	public void setGenelId(Long genelId) {
		this.genelId = genelId;
	}
}
