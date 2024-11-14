package com.example.model;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CountryLangCompositeID implements Serializable {

	public CountryLangCompositeID() {
	}
	
	public CountryLangCompositeID(String code, String lang) {
		super();
		this.code = code;
		this.lang = lang;
	}

	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private String code;

	@Column(name = "lang")
	private String lang;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, lang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryLangCompositeID other = (CountryLangCompositeID) obj;
		return Objects.equals(code, other.code) && Objects.equals(lang, other.lang);
	}

}
