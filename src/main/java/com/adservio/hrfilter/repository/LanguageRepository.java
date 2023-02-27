package com.adservio.hrfilter.repository;

import com.adservio.hrfilter.data.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findByLanguage(String language);
}
