package com.techie.recodetarim.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techie.recodetarim.domain.entities.Forms;

public interface FormsRepository extends JpaRepository<Forms, Long> {
}
