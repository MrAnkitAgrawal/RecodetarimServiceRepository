package com.techie.recodetarim.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techie.recodetarim.domain.entities.FormsDegerlendirmeImza;

public interface FormsDegerlendirmeImzaRepository extends JpaRepository<FormsDegerlendirmeImza, Long> {
	public List<FormsDegerlendirmeImza> findByGenelId(Long genelId);
}
