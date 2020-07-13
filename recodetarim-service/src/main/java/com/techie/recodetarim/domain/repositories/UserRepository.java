package com.techie.recodetarim.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techie.recodetarim.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByKodAndSifre(String username, String password);
}
