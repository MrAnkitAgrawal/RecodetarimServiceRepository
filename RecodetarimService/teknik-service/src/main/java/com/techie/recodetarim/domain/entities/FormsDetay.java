package com.techie.recodetarim.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formsdetay")
public class FormsDetay implements Serializable {
	private static final long serialVersionUID = -1315988474181676605L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "form_no")
	private Long formNo;

	@Column(name = "type")
	private String type;

	@Column(name = "default_value")
	private String defaultValue;

	@Column(name = "not_null")
	private int notNull;

	@Column(name = "title")
	private String title;

	protected FormsDetay() {
	}

	public FormsDetay(Long id, Long formNo, String type, String defaultValue, int notNull, String title) {
		this.id = id;
		this.formNo = formNo;
		this.type = type;
		this.defaultValue = defaultValue;
		this.notNull = notNull;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFormNo() {
		return formNo;
	}

	public void setFormNo(Long formNo) {
		this.formNo = formNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public int getNotNull() {
		return notNull;
	}

	public void setNotNull(int notNull) {
		this.notNull = notNull;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "FormsDetay [id=" + id + ", formNo=" + formNo + ", type=" + type + ", defaultValue=" + defaultValue
				+ ", notNull=" + notNull + ", title=" + title + "]";
	}
}
