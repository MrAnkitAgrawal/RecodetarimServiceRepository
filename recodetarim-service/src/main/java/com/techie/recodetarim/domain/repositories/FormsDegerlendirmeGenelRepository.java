package com.techie.recodetarim.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techie.recodetarim.domain.entities.FormsDegerlendirmeGenel;

public interface FormsDegerlendirmeGenelRepository extends JpaRepository<FormsDegerlendirmeGenel, Long> {
	@Query("SELECT max(f.formNo) FROM FormsDegerlendirmeGenel f")
	public Optional<Long> retrieveMaxFormNo();
}
