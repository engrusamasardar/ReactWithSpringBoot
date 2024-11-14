package com.example.repo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.model.CountryLang;
import com.example.model.CountryLangCompositeID;

@Repository
public interface CountryLangRepo extends CrudRepository<CountryLang, CountryLangCompositeID>{

	@Query(value = "SELECT CountryCode as 'code', language as 'lang', IsOfficial as 'official' FROM countrylanguage LIMIT :limit", nativeQuery = true)
	List<CountryLang> findAllByLimit(@Param("limit") int limit);
	
}
