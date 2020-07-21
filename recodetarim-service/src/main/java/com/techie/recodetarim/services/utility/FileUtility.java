package com.techie.recodetarim.services.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64.Encoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techie.recodetarim.domain.entities.FormsDegerlendirmeImza;
import com.techie.recodetarim.domain.entities.FormsDegerlendirmeResim;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeImzaRepository;
import com.techie.recodetarim.domain.repositories.FormsDegerlendirmeResimRepository;
import com.techie.recodetarim.domain.repositories.ParametreRepository;
import com.techie.recodetarim.models.FormsDegerlendirmeImzaDto;

@Component
public class FileUtility {
	private ParametreRepository parametreRepository;
	private FormsDegerlendirmeResimRepository formsDegerlendirmeResimRepository;
	private FormsDegerlendirmeImzaRepository formsDegerlendirmeImzaRepository;
	private Encoder base64Encoder;
	private final String filePathStr;

	private static final String JPG = ".jpg";
	private static final String SIGNATURE = "imza";
	private static final String KONTROL_FORM = "kontrolform";

	@Autowired
	public FileUtility(ParametreRepository parametreRepository,
			FormsDegerlendirmeResimRepository formsDegerlendirmeResimRepository,
			FormsDegerlendirmeImzaRepository formsDegerlendirmeImzaRepository, Encoder base64Encoder) {
		this.parametreRepository = parametreRepository;
		this.formsDegerlendirmeResimRepository = formsDegerlendirmeResimRepository;
		this.formsDegerlendirmeImzaRepository = formsDegerlendirmeImzaRepository;
		this.base64Encoder = base64Encoder;
		filePathStr = this.parametreRepository.fetchFilePath();
	}

	public List<FormsDegerlendirmeImzaDto> retrieveAllImages(long genelId) throws IOException {
		List<FormsDegerlendirmeImzaDto> formsDegerlendirmeImzaDtos = new ArrayList<>();

		List<FormsDegerlendirmeImza> formsDegerlendirmeImzas = formsDegerlendirmeImzaRepository.findByGenelId(genelId);
		if (formsDegerlendirmeImzas != null) {
			for (FormsDegerlendirmeImza formsDegerlendirmeImza : formsDegerlendirmeImzas) {
				final String imageName = formsDegerlendirmeImza.getImageId();
				final String imagePath = formsDegerlendirmeImza.getImage();
				if (imageName == null || imagePath == null) {
					continue;
				}

				String image = base64Encoder.encodeToString(retrieveImage(imagePath));
				FormsDegerlendirmeImzaDto FormsDegerlendirmeImzaDto = new FormsDegerlendirmeImzaDto();
				FormsDegerlendirmeImzaDto.setImageId(imageName);
				FormsDegerlendirmeImzaDto.setImage(image);
				formsDegerlendirmeImzaDtos.add(FormsDegerlendirmeImzaDto);
			}
		}

		return formsDegerlendirmeImzaDtos;
	}

	public byte[] retrieveImage(String imagePath) throws IOException {
		return Files.readAllBytes(Paths.get(imagePath));
	}

	public void saveImage(long genelId, long fisNo, long formNo, byte[] fileContent, final String imageName)
			throws IOException {
		Path imageFilePath = prepareImageFilePath(fisNo, formNo, imageName);
		Files.write(imageFilePath, fileContent);

		FormsDegerlendirmeImza formsDegerlendirmeImza = new FormsDegerlendirmeImza();
		formsDegerlendirmeImza.setImageId(imageName);
		formsDegerlendirmeImza.setImage(imageFilePath.toString());
		formsDegerlendirmeImza.setGenelId(genelId);

		formsDegerlendirmeImzaRepository.save(formsDegerlendirmeImza);
	}

	private Path prepareImageFilePath(long fisNo, long formNo, final String imageName) throws IOException {
		Path imageFilePath = Paths.get(filePathStr, KONTROL_FORM, String.valueOf(formNo));
		String imageFileName = imageName + JPG;
		return createFilePath(imageFilePath, imageFileName);
	}

	public byte[] retrieveSignature(long genelId) throws IOException {
		FormsDegerlendirmeResim formsDegerlendirmeResim = formsDegerlendirmeResimRepository.findByGenelId(genelId);
		if (formsDegerlendirmeResim == null) {
			return null;
		}

		final String signatureFilePath = formsDegerlendirmeResim.getSignature();
		if (signatureFilePath == null) {
			return null;
		}
		return Files.readAllBytes(Paths.get(signatureFilePath));
	}

	public void saveSignature(long genelId, long fisNo, long formNo, byte[] fileContent) throws IOException {
		Path signatureFilePath = prepareSignatureFilePath(fisNo, formNo);
		Files.write(signatureFilePath, fileContent);

		FormsDegerlendirmeResim formsDegerlendirmeResim = new FormsDegerlendirmeResim();
		formsDegerlendirmeResim.setSignature(signatureFilePath.toString());
		formsDegerlendirmeResim.setGenelId(genelId);

		formsDegerlendirmeResimRepository.save(formsDegerlendirmeResim);
	}

	private Path prepareSignatureFilePath(long fisNo, long formNo) throws IOException {
		Path signatureFilePath = Paths.get(filePathStr, SIGNATURE);
		final String signatureFileName = fisNo + "_" + formNo + "_sign" + JPG;
		return createFilePath(signatureFilePath, signatureFileName);
	}

	private Path createFilePath(Path signatureFilePath, final String signatureFileName) throws IOException {
		Path path = null;
		Files.createDirectories(signatureFilePath);
		path = Paths.get(signatureFilePath.toString(), signatureFileName);
		return path;
	}
}
