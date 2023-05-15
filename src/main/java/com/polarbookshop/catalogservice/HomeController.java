package com.polarbookshop.catalogservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarbookshop.catalogservice.config.PolarProperties;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {

	@Value("${server.port}")
	private String serverPort;

	private final PolarProperties polarProps;

	@GetMapping("/")
	public String getGreeting() {
		return String.format(polarProps.getGreeting(), serverPort);
	}
}
