package com.adservio.hrfilter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adservio.hrfilter.data.model.Question;
import com.adservio.hrfilter.enums.QuestionLevel;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	public List<Question> findBySkillIgnoreCaseAndQuestionLevel(String skill, QuestionLevel level);
}
