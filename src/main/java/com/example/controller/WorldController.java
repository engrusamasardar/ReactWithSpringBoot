package com.example.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.codes.ResponseCode;
import com.example.model.CountryLang;
import com.example.repo.CountryLangRepo;

@RestController
public class WorldController {

	@Autowired
	private CountryLangRepo countryLangRepo;
	private static final Logger logger = LoggerFactory.getLogger(WorldController.class);
	private List<CountryLang> countryLangList = null;

	@GetMapping("/countrylang")
	public ResponseEntity<List<CountryLang>> LanguageList() {
		int limit = 25;
		try {
			logger.info("Calling funcion: findAllByLimit(" + limit + ")");
			countryLangList = countryLangRepo.findAllByLimit(limit);
			if (countryLangList == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			logger.info("Exception caught: " + e);
			logger.info("Returning response: " + ResponseCode.NotFound_404);
			return ResponseEntity.notFound().build();
		}
		logger.info("Returning response: " + ResponseCode.Ok_200);
		return ResponseEntity.ok(countryLangList);
	}
}
