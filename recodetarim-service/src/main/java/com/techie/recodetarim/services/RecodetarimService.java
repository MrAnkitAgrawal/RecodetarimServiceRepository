package com.techie.recodetarim.services;

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
import com.techie.recodetarim.domain.entities.FormsDegerlendirmeImza;
import com.techie.recodetarim.domain.entities.FormsDegerlendirmeResim;
import com.techie.recodetarim.domain.entities.FormsDetay;
import com.techie.recodetarim.domain.repositories.CariRepository;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeGenelRepository;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeImzaRepository;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeRepository;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeResimRepository;
import com.techie.recodetarim.domain.repositories.FormsDetayRepository;
import com.techie.recodetarim.domain.repositories.FormsRepository;
import com.techie.recodetarim.models.FormsDegerlendirmeDetails;
import com.techie.recodetarim.models.FormsDegerlendirmeImzaDto;

@Service
public class RecodetarimService {
	private FormsRepository formsRepository;
	private FormsDetayRepository formsDetayRepository;
	private CariRepository cariRepository;
	private FormsDegerlendirmeGenelRepository formsDegerlendirmeGenelRepository;
	private FormsDegerlendirmeRepository formsDegerlendirmeRepository;
	private FormsDegerlendirmeResimRepository formsDegerlendirmeResimRepository;
	private FormsDegerlendirmeImzaRepository formsDegerlendirmeImzaRepository;

	@Autowired
	public RecodetarimService(FormsRepository formsRepository, FormsDetayRepository formsDetayRepository,
			CariRepository cariRepository, FormsDegerlendirmeGenelRepository formsDegerlendirmeGenelRepository,
			FormsDegerlendirmeRepository formsDegerlendirmeRepository,
			FormsDegerlendirmeResimRepository formsDegerlendirmeResimRepository,
			FormsDegerlendirmeImzaRepository formsDegerlendirmeImzaRepository) {
		this.formsRepository = formsRepository;
		this.formsDetayRepository = formsDetayRepository;
		this.cariRepository = cariRepository;
		this.formsDegerlendirmeGenelRepository = formsDegerlendirmeGenelRepository;
		this.formsDegerlendirmeRepository = formsDegerlendirmeRepository;
		this.formsDegerlendirmeResimRepository = formsDegerlendirmeResimRepository;
		this.formsDegerlendirmeImzaRepository = formsDegerlendirmeImzaRepository;
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
	public FormsDegerlendirmeDetails saveFormsDegerlendirmeDetails(
			FormsDegerlendirmeDetails formsDegerlendirmeDetails) {
		FormsDegerlendirmeGenel formsDegerlendirmeGenel = formsDegerlendirmeDetails.getFormsDegerlendirmeGenel();
		if (formsDegerlendirmeGenel != null) {
			synchronized (this) {
				Long maxFormNo = formsDegerlendirmeGenelRepository.retrieveMaxFormNo().orElse(0l);
				formsDegerlendirmeGenel.setFormNo(++maxFormNo);
				formsDegerlendirmeGenelRepository.save(formsDegerlendirmeGenel);
			}
		}

		List<FormsDegerlendirme> formsDegerlendirmes = formsDegerlendirmeDetails.getFormsDegerlendirmes();
		if (formsDegerlendirmes != null) {
			formsDegerlendirmes.forEach(formsDegerlendirme -> {
				formsDegerlendirme.setGenelId(formsDegerlendirmeGenel.getId());
				formsDegerlendirmeRepository.save(formsDegerlendirme);
			});
		}

		String SignatuteStr = formsDegerlendirmeDetails.getSignature();
		if (SignatuteStr != null) {
			byte[] signatureBytes = formsDegerlendirmeDetails.getSignature().getBytes(StandardCharsets.ISO_8859_1);

			FormsDegerlendirmeResim formsDegerlendirmeResim = new FormsDegerlendirmeResim();
			formsDegerlendirmeResim.setSignature(signatureBytes);
			formsDegerlendirmeResim.setGenelId(formsDegerlendirmeGenel.getId());
			formsDegerlendirmeResimRepository.save(formsDegerlendirmeResim);
		}

		List<FormsDegerlendirmeImzaDto> formsDegerlendirmeImzaDtos = formsDegerlendirmeDetails
				.getFormsDegerlendirmeImzas();
		formsDegerlendirmeImzaDtos.forEach(formsDegerlendirmeImzaDto -> {
			FormsDegerlendirmeImza formsDegerlendirmeImza = new FormsDegerlendirmeImza();
			formsDegerlendirmeImza.setImageId(formsDegerlendirmeImzaDto.getImageId());
			formsDegerlendirmeImza.setImage(formsDegerlendirmeImzaDto.getImage().getBytes(StandardCharsets.ISO_8859_1));
			formsDegerlendirmeImza.setGenelId(formsDegerlendirmeGenel.getId());
			formsDegerlendirmeImzaRepository.save(formsDegerlendirmeImza);
		});

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

		FormsDegerlendirmeResim formsDegerlendirmeResim = formsDegerlendirmeResimRepository.findByGenelId(genelId);
		if (formsDegerlendirmeResim != null) {
			byte[] signBytes = formsDegerlendirmeResim.getSignature();
			String signature = new String(signBytes, StandardCharsets.ISO_8859_1);
			formsDegerlendirmeDetails.setSignature(signature);
		}

		List<FormsDegerlendirmeImza> formsDegerlendirmeImzas = formsDegerlendirmeImzaRepository.findByGenelId(genelId);
		if (formsDegerlendirmeImzas != null) {
			formsDegerlendirmeImzas.forEach(formsDegerlendirmeImza -> {
				FormsDegerlendirmeImzaDto FormsDegerlendirmeImzaDto = new FormsDegerlendirmeImzaDto();
				FormsDegerlendirmeImzaDto.setImageId(formsDegerlendirmeImza.getImageId());

				String image = new String(formsDegerlendirmeImza.getImage(), StandardCharsets.ISO_8859_1);
				FormsDegerlendirmeImzaDto.setImage(image);
				formsDegerlendirmeDetails.getFormsDegerlendirmeImzas().add(FormsDegerlendirmeImzaDto);
			});
		}

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
