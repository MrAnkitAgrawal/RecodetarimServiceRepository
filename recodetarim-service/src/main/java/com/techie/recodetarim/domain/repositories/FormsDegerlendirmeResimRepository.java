package com.techie.recodetarim.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techie.recodetarim.domain.entities.FormsDegerlendirmeResim;

public interface FormsDegerlendirmeResimRepository extends JpaRepository<FormsDegerlendirmeResim, Long> {
	public FormsDegerlendirmeResim findByGenelId(Long genelId);
}
