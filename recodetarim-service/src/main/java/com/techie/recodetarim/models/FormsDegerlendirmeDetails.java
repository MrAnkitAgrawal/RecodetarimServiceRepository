package com.techie.recodetarim.models;

import java.util.ArrayList;
import java.util.List;

import com.techie.recodetarim.domain.entities.FormsDegerlendirme;
import com.techie.recodetarim.domain.entities.FormsDegerlendirmeGenel;

public class FormsDegerlendirmeDetails {
	private FormsDegerlendirmeGenel formsDegerlendirmeGenel;
	private List<FormsDegerlendirme> formsDegerlendirmes = new ArrayList<>();
	private String signature;
	private List<FormsDegerlendirmeImzaDto> formsDegerlendirmeImzas = new ArrayList<>();

	public FormsDegerlendirmeGenel getFormsDegerlendirmeGenel() {
		return formsDegerlendirmeGenel;
	}

	public void setFormsDegerlendirmeGenel(FormsDegerlendirmeGenel formsDegerlendirmeGenel) {
		this.formsDegerlendirmeGenel = formsDegerlendirmeGenel;
	}

	public List<FormsDegerlendirme> getFormsDegerlendirmes() {
		return formsDegerlendirmes;
	}

	public void setFormsDegerlendirmes(List<FormsDegerlendirme> formsDegerlendirmes) {
		this.formsDegerlendirmes = formsDegerlendirmes;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<FormsDegerlendirmeImzaDto> getFormsDegerlendirmeImzas() {
		return formsDegerlendirmeImzas;
	}

	public void setFormsDegerlendirmeImzas(List<FormsDegerlendirmeImzaDto> formsDegerlendirmeImzas) {
		this.formsDegerlendirmeImzas = formsDegerlendirmeImzas;
	}
}
