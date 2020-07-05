package com.techie.recodetarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techie.recodetarim.domain.entities.Cari;
import com.techie.recodetarim.domain.entities.Forms;
import com.techie.recodetarim.domain.entities.FormsDetay;
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
}
