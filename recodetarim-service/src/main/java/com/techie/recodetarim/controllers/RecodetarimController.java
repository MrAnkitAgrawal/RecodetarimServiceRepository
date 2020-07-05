package com.techie.recodetarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techie.recodetarim.domain.entities.Forms;
import com.techie.recodetarim.domain.entities.FormsDetay;
import com.techie.recodetarim.services.RecodetarimService;

@RestController
@RequestMapping("/recodetarim")
public class RecodetarimController {
	@Autowired
	private RecodetarimService recodetarimService;

	@GetMapping("/forms")
	public List<Forms> retrieveForms() {
		return recodetarimService.retrieveForms();
	}

	@GetMapping("/formsdetay")
	public List<FormsDetay> retrieveFormsDetay() {
		return recodetarimService.retrieveFormsDetay();
	}
}