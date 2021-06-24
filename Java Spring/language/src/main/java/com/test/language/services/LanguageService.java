package com.test.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.language.models.Language;
import com.test.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<Language> allLanguage() {
		return languageRepository.findAll();
	}

	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}

	public Language findLanguage(Long id) {
		Optional<Language> optionallanguage = languageRepository.findById(id);
		if (optionallanguage.isPresent()) {
			return optionallanguage.get();
		} else {
			return null;
		}
	}

	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);		
	}

	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}
}

