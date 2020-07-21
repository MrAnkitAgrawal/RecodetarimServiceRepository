package com.techie.recodetarim.configuration;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericConfiguration {
	@Bean
	public Decoder getBase64Decoder() {
		return Base64.getDecoder();
	}
	
	@Bean
	public Encoder getBase64Encoder() {
		return Base64.getEncoder();
	}
}
