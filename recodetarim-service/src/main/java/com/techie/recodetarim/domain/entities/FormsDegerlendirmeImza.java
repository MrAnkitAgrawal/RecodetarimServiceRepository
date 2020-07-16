package com.techie.recodetarim.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formsdegerlendirmeimza")
public class FormsDegerlendirmeImza implements Serializable {
	private static final long serialVersionUID = 5132549898953561343L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "image_id")
	private String imageId;

	@Column(name = "image")
	private String image;

	@Column(name = "genel_id")
	private Long genelId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getGenelId() {
		return genelId;
	}

	public void setGenelId(Long genelId) {
		this.genelId = genelId;
	}
}
