package com.malak.Languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.malak.Languages.models.Language;
import com.malak.Languages.repositories.languageRepository;

@Service
public class languageService {
	private final languageRepository languageRepository;

	public languageService(languageRepository bookRepository) {
		this.languageRepository = bookRepository;
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
