package com.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.model.CountryLang;
import com.example.model.CountryLangCompositeID;
import com.example.repo.CountryLangRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CountryLangRepoTest {
	
	

	@Autowired
	private CountryLangRepo countryLangRepo = null;
	//private static final Logger logger = LoggerFactory.getLogger(CountryLangRepoTest.class);
	
	@Test
	public void countryLanglistNotNull() {
		List<CountryLang> countryLangsList = countryLangRepo.findAllByLimit(25);
		assertNotNull(countryLangsList);
	}

	@Test
	public void countryLanglistContainsSimple() {
		CountryLangCompositeID compositeId = new CountryLangCompositeID();
		compositeId.setCode("AFG");
		compositeId.setLang("Pashto");
		CountryLang countryLang = new CountryLang();
		countryLang.setCompositeId(compositeId);
		countryLang.setOfficial('T');
		List<CountryLang> countryLangsList = countryLangRepo.findAllByLimit(25);
		Assertions.assertTrue(countryLangsList.contains(countryLang));
	}

	@Test
	public void countryLanglistContainsStream() {
		
		List<CountryLang> countryLangsList = countryLangRepo.findAllByLimit(25);
		CountryLang countryLang = new CountryLang();
		countryLang = countryLangsList.stream().filter(obj -> obj.getCompositeId().getLang().equals("Pashto"))
				.reduce(countryLang, (result, resultAsPerson) -> resultAsPerson);
//		logger.info("Returned result using stream: "+countryLang);
		assertNotNull(countryLangsList.contains(countryLang));
	}
}
