package com.techie.recodetarim.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techie.recodetarim.domain.entities.Cari;
import com.techie.recodetarim.domain.entities.Forms;
import com.techie.recodetarim.domain.entities.FormsDetay;
import com.techie.recodetarim.domain.entities.User;
import com.techie.recodetarim.models.FormsDegerlendirmeDetails;
import com.techie.recodetarim.services.RecodetarimService;

@RestController
@RequestMapping("/recodetarim")
public class RecodetarimController {
	private RecodetarimService recodetarimService;

	@Autowired
	public RecodetarimController(RecodetarimService recodetarimService) {
		this.recodetarimService = recodetarimService;
	}

	@GetMapping("/forms")
	public List<Forms> retrieveForms() {
		return recodetarimService.retrieveForms();
	}

	@GetMapping("/formsdetay")
	public List<FormsDetay> retrieveFormsDetays() {
		return recodetarimService.retrieveFormsDetays();
	}

	@GetMapping("/cari")
	public List<Cari> retrieveCaris() {
		return recodetarimService.retrieveCaris();
	}

	@PostMapping("/formsdegerlendime")
	public ResponseEntity<FormsDegerlendirmeDetails> saveFormsDegerlendirmeDetails(
			@RequestBody FormsDegerlendirmeDetails formsDegerlendirmeDetails) throws IOException {
		recodetarimService.saveFormsDegerlendirmeDetails(formsDegerlendirmeDetails);
		return new ResponseEntity<>(formsDegerlendirmeDetails, HttpStatus.CREATED);
	}

	@GetMapping("/formsdegerlendime")
	public List<FormsDegerlendirmeDetails> getAllFormsDegerlendirmeDetails() throws IOException {
		return recodetarimService.getAllFormsDegerlendirmeDetails();
	}

	@GetMapping("/formsdegerlendime/{genelId}")
	public FormsDegerlendirmeDetails getFormsDegerlendirmeDetails(@PathVariable Long genelId) throws IOException {
		return recodetarimService.getFormsDegerlendirmeDetails(genelId);
	}

	@PostMapping("/user")
	public ResponseEntity<User> validateUserCredential(@RequestBody Map<String, String> userCredential) {
		final String username = userCredential.get("kod");
		final String password = userCredential.get("sifre");
		Optional<User> userOptional = recodetarimService.retrieveUser(username, password);
		if (userOptional.isPresent()) {
			return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}
