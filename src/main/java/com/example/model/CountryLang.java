package com.example.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "countrylanguage")
public class CountryLang implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public CountryLang(){
		
	}
	
	@EmbeddedId
	private CountryLangCompositeID compositeId; 
	
	@Column(name ="official")
	private Character official;

	public Character getOfficial() {
		return official;
	}

	@Override
	public String toString() {
		return "CountryLang [compositeId=" + compositeId + ", official=" + official + "]";
	}

	public void setOfficial(Character official) {
		this.official = official;
	}

	public CountryLangCompositeID getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(CountryLangCompositeID compositeId) {
		this.compositeId = compositeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compositeId, official);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryLang other = (CountryLang) obj;
		return Objects.equals(compositeId, other.compositeId) && official == other.official;
	}	
}
