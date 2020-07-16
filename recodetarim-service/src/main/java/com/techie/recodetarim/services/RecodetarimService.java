package com.techie.recodetarim.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
import com.techie.recodetarim.domain.entities.User;
import com.techie.recodetarim.domain.repositories.CariRepository;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeGenelRepository;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeRepository;
import com.techie.recodetarim.domain.repositories.FormsDetayRepository;
import com.techie.recodetarim.domain.repositories.FormsRepository;
import com.techie.recodetarim.models.FormsDegerlendirmeDetails;
import com.techie.recodetarim.models.FormsDegerlendirmeImzaDto;
import com.techie.recodetarim.services.utility.FileUtility;
import com.techie.recodetarim.domain.repositories.UserRepository;

@Service
public class RecodetarimService {
	private FormsRepository formsRepository;
	private FormsDetayRepository formsDetayRepository;
	private CariRepository cariRepository;
	private FormsDegerlendirmeGenelRepository formsDegerlendirmeGenelRepository;
	private FormsDegerlendirmeRepository formsDegerlendirmeRepository;

	private UserRepository userRepository;
	private FileUtility fileUtility;

	@Autowired
	public RecodetarimService(FormsRepository formsRepository, FormsDetayRepository formsDetayRepository,
			CariRepository cariRepository, FormsDegerlendirmeGenelRepository formsDegerlendirmeGenelRepository,
			FormsDegerlendirmeRepository formsDegerlendirmeRepository, UserRepository userRepository,
			FileUtility fileUtility) {
		this.formsRepository = formsRepository;
		this.formsDetayRepository = formsDetayRepository;
		this.cariRepository = cariRepository;
		this.formsDegerlendirmeGenelRepository = formsDegerlendirmeGenelRepository;
		this.formsDegerlendirmeRepository = formsDegerlendirmeRepository;
		this.userRepository = userRepository;
		this.fileUtility = fileUtility;
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
	public FormsDegerlendirmeDetails saveFormsDegerlendirmeDetails(FormsDegerlendirmeDetails formsDegerlendirmeDetails)
			throws IOException {
		FormsDegerlendirmeGenel formsDegerlendirmeGenel = formsDegerlendirmeDetails.getFormsDegerlendirmeGenel();
		if (formsDegerlendirmeGenel != null) {
			synchronized (this) {
				Long maxFormNo = formsDegerlendirmeGenelRepository.retrieveMaxFormNo().orElse(0l);
				formsDegerlendirmeGenel.setFormNo(++maxFormNo);
				formsDegerlendirmeGenelRepository.save(formsDegerlendirmeGenel);
			}
		}

		long genelId = formsDegerlendirmeGenel.getId();
		long fisNo = formsDegerlendirmeGenel.getFisNo();
		long formNo = formsDegerlendirmeGenel.getFormNo();

		saveFormsDegerlendirmes(formsDegerlendirmeDetails, genelId);
		saveSignature(formsDegerlendirmeDetails, genelId, fisNo, formNo);
		saveImages(formsDegerlendirmeDetails, genelId, fisNo, formNo);

		return formsDegerlendirmeDetails;
	}

	public FormsDegerlendirmeDetails getFormsDegerlendirmeDetails(Long genelId) throws IOException {
		FormsDegerlendirmeDetails formsDegerlendirmeDetails = new FormsDegerlendirmeDetails();

		Optional<FormsDegerlendirmeGenel> oFormsDegerlendirmeGenel = formsDegerlendirmeGenelRepository
				.findById(genelId);
		if (!oFormsDegerlendirmeGenel.isPresent()) {
			return new FormsDegerlendirmeDetails();
		}

		FormsDegerlendirmeGenel formsDegerlendirmeGenel = oFormsDegerlendirmeGenel.get();
		formsDegerlendirmeDetails.setFormsDegerlendirmeGenel(formsDegerlendirmeGenel);

		// Retrieve and set FormsDegerlendirme list
		List<FormsDegerlendirme> formsDegerlendirmes = formsDegerlendirmeRepository.findByGenelId(genelId);
		formsDegerlendirmeDetails.setFormsDegerlendirmes(formsDegerlendirmes);

		// Retrieve and set signature
		byte[] signatureBytes = fileUtility.retrieveSignature(genelId);
		if (signatureBytes != null) {
			String signature = new String(signatureBytes, StandardCharsets.ISO_8859_1);
			formsDegerlendirmeDetails.setSignature(signature);
		}

		// Retrieve and set images
		formsDegerlendirmeDetails.setFormsDegerlendirmeImzas(fileUtility.retrieveAllImages(genelId));

		return formsDegerlendirmeDetails;
	}

	public List<FormsDegerlendirmeDetails> getAllFormsDegerlendirmeDetails() throws IOException {
		List<FormsDegerlendirmeDetails> formsDegerlendirmeDetailsList = new ArrayList<>();

		List<FormsDegerlendirmeGenel> formsDegerlendirmeGenels = formsDegerlendirmeGenelRepository.findAll();
		for (FormsDegerlendirmeGenel formsDegerlendirmeGenel : formsDegerlendirmeGenels) {
			formsDegerlendirmeDetailsList.add(getFormsDegerlendirmeDetails(formsDegerlendirmeGenel.getId()));
		}

		return formsDegerlendirmeDetailsList;
	}

	public Optional<User> retrieveUser(final String userName, final String password) {
		return userRepository.findByKodAndSifre(userName, password);
	}

	private void saveImages(FormsDegerlendirmeDetails formsDegerlendirmeDetails, long genelId, long fisNo, long formNo)
			throws IOException {
		for (FormsDegerlendirmeImzaDto formsDegerlendirmeImzaDto : formsDegerlendirmeDetails
				.getFormsDegerlendirmeImzas()) {
			final String imageName = formsDegerlendirmeImzaDto.getImageId();
			byte[] imageButes = formsDegerlendirmeImzaDto.getImage().getBytes(StandardCharsets.ISO_8859_1);
			fileUtility.saveImage(genelId, fisNo, formNo, imageButes, imageName);
		}
	}

	private void saveSignature(FormsDegerlendirmeDetails formsDegerlendirmeDetails, long genelId, long fisNo,
			long formNo) throws IOException {
		if (formsDegerlendirmeDetails.getSignature() != null) {
			byte[] signatureBytes = formsDegerlendirmeDetails.getSignature().getBytes(StandardCharsets.ISO_8859_1);
			fileUtility.saveSignature(genelId, fisNo, formNo, signatureBytes);
		}
	}

	private void saveFormsDegerlendirmes(FormsDegerlendirmeDetails formsDegerlendirmeDetails, long genelId) {
		List<FormsDegerlendirme> formsDegerlendirmes = formsDegerlendirmeDetails.getFormsDegerlendirmes();
		if (formsDegerlendirmes != null) {
			formsDegerlendirmes.forEach(formsDegerlendirme -> {
				formsDegerlendirme.setGenelId(genelId);
				formsDegerlendirmeRepository.save(formsDegerlendirme);
			});
		}
	}

}
