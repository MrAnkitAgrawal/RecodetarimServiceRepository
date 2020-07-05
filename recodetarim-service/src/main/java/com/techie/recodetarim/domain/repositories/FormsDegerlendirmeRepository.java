package com.techie.recodetarim.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techie.recodetarim.domain.entities.FormsDegerlendirme;

public interface FormsDegerlendirmeRepository extends JpaRepository<FormsDegerlendirme, Long> {
	public List<FormsDegerlendirme> findByGenelId(Long genelId);
}
