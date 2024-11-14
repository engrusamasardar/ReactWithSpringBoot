package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.CountryLang;
import com.example.repo.CountryLangRepo;

@RestController
public class WorldController {
	
	@Autowired
	private CountryLangRepo countryLangRepo;
	
	@GetMapping("/countrylang")
	public List<CountryLang> LanguageList(){
		return countryLangRepo.findAllByLimit(50);
	}
}
