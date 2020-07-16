package com.techie.recodetarim.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techie.recodetarim.domain.entities.Parametre;

public interface ParametreRepository extends JpaRepository<Parametre, Long> {
	@Query("SELECT p.deger FROM Parametre p WHERE p.secenek = 'resim_yolu'")
	public String fetchFilePath();
}
