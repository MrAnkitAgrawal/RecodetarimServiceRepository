package com.techie.recodetarim.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forms")
public class Forms implements Serializable {
	private static final long serialVersionUID = -2131992801328779005L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "form_no")
	private Long formNo;

	@Column(name = "form_name")
	private String formName;

	@Column(name = "jasper_form_name")
	private String jasperFormName;

	protected Forms() {
	}

	public Forms(Long id, Long formNo, String formName, String jasperFormName) {
		this.id = id;
		this.formNo = formNo;
		this.formName = formName;
		this.jasperFormName = jasperFormName;
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

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getJasperFormName() {
		return jasperFormName;
	}

	public void setJasperFormName(String jasperFormName) {
		this.jasperFormName = jasperFormName;
	}

	@Override
	public String toString() {
		return "Forms [id=" + id + ", formNo=" + formNo + ", formName=" + formName + ", jasperFormName="
				+ jasperFormName + "]";
	}
}
