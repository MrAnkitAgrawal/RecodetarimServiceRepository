package com.techie.recodetarim.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.techie.recodetarim.domain.entities.Cari;
import com.techie.recodetarim.domain.entities.Forms;
import com.techie.recodetarim.domain.entities.FormsDegerlendirme;
import com.techie.recodetarim.domain.entities.FormsDegerlendirmeGenel;
import com.techie.recodetarim.domain.entities.FormsDetay;
import com.techie.recodetarim.domain.repositories.CariRepository;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeGenelRepository;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeRepository;
import com.techie.recodetarim.domain.repositories.FormsDetayRepository;
import com.techie.recodetarim.domain.repositories.FormsRepository;

@Service
public class RecodetarimService {
	private FormsRepository formsRepository;
	private FormsDetayRepository formsDetayRepository;
	private CariRepository cariRepository;
	private FormsDegerlendirmeGenelRepository formsDegerlendirmeGenelRepository;
	private FormsDegerlendirmeRepository formsDegerlendirmeRepository;

	@Autowired
	public RecodetarimService(FormsRepository formsRepository, FormsDetayRepository formsDetayRepository,
			CariRepository cariRepository, FormsDegerlendirmeGenelRepository formsDegerlendirmeGenelRepository,
			FormsDegerlendirmeRepository formsDegerlendirmeRepository) {
		this.formsRepository = formsRepository;
		this.formsDetayRepository = formsDetayRepository;
		this.cariRepository = cariRepository;
		this.formsDegerlendirmeGenelRepository = formsDegerlendirmeGenelRepository;
		this.formsDegerlendirmeRepository = formsDegerlendirmeRepository;
	}

	public List<Forms> retrieveForms() {
		return formsRepository.findAll();
	}

	public List<FormsDetay> retrieveFormsDetays() {
		return formsDetayRepository.findAll();
	}

	public List<Cari> retrieveCaris() {
		return cariRepository.findAll();
	}

	@Transactional
	public FormsDegerlendirmeDetails saveFormsDegerlendirmeDetails(FormsDegerlendirmeDetails formsDegerlendirmeDetails) {
		FormsDegerlendirmeGenel formsDegerlendirmeGenel = formsDegerlendirmeDetails.getFormsDegerlendirmeGenel();
		if (formsDegerlendirmeGenel != null) {
			formsDegerlendirmeGenelRepository.save(formsDegerlendirmeGenel);
		}

		List<FormsDegerlendirme> formsDegerlendirmes = formsDegerlendirmeDetails.getFormsDegerlendirmes();
		if (formsDegerlendirmes != null) {
			formsDegerlendirmes.forEach(formsDegerlendirme -> {
				formsDegerlendirme.setGenelId(formsDegerlendirmeGenel.getId());
				formsDegerlendirmeRepository.save(formsDegerlendirme);
			});
		}

		return formsDegerlendirmeDetails;
	}

	public FormsDegerlendirmeDetails getFormsDegerlendirmeDetails(Long genelId) {
		FormsDegerlendirmeDetails formsDegerlendirmeDetails = new FormsDegerlendirmeDetails();

		Optional<FormsDegerlendirmeGenel> formsDegerlendirmeGenelOptional = formsDegerlendirmeGenelRepository
				.findById(genelId);

		if (!formsDegerlendirmeGenelOptional.isPresent()) {
			return new FormsDegerlendirmeDetails();
		}

		formsDegerlendirmeDetails.setFormsDegerlendirmeGenel(formsDegerlendirmeGenelOptional.get());

		List<FormsDegerlendirme> formsDegerlendirmes = formsDegerlendirmeRepository.findByGenelId(genelId);
		formsDegerlendirmeDetails.setFormsDegerlendirmes(formsDegerlendirmes);

		return formsDegerlendirmeDetails;
	}

	public List<FormsDegerlendirmeDetails> getAllFormsDegerlendirmeDetails() {
		List<FormsDegerlendirmeDetails> formsDegerlendirmeDetailsList = new ArrayList<>();

		List<FormsDegerlendirmeGenel> formsDegerlendirmeGenels = formsDegerlendirmeGenelRepository.findAll();
		formsDegerlendirmeGenels.forEach(formsDegerlendirmeGenel -> {
			formsDegerlendirmeDetailsList.add(getFormsDegerlendirmeDetails(formsDegerlendirmeGenel.getId()));
		});

		return formsDegerlendirmeDetailsList;
	}
}
