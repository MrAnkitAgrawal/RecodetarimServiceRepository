package com.techie.recodetarim.services;

import java.util.ArrayList;
import java.util.List;

import com.techie.recodetarim.domain.entities.FormsDegerlendirme;
import com.techie.recodetarim.domain.entities.FormsDegerlendirmeGenel;

public class FormsDegerlendirmeDetails {
	private FormsDegerlendirmeGenel formsDegerlendirmeGenel;
	private List<FormsDegerlendirme> formsDegerlendirmes = new ArrayList<>();

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
}
