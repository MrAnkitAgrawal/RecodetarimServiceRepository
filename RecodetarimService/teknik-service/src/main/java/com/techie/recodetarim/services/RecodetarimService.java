package com.techie.recodetarim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techie.recodetarim.domain.entities.Forms;
import com.techie.recodetarim.domain.entities.FormsDetay;
import com.techie.recodetarim.domain.repositories.FormsDetayRepository;
import com.techie.recodetarim.domain.repositories.FormsRepository;

@Service
public class RecodetarimService {
	private FormsRepository formsRepository;
	private FormsDetayRepository formsDetayRepository;

	@Autowired
	public RecodetarimService(FormsRepository formsRepository, FormsDetayRepository formsDetayRepository) {
		this.formsRepository = formsRepository;
		this.formsDetayRepository = formsDetayRepository;
	}

	public List<Forms> retrieveForms() {
		return formsRepository.findAll();
	}

	public List<FormsDetay> retrieveFormsDetay() {
		return formsDetayRepository.findAll();
	}
}
