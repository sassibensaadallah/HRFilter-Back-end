package com.adservio.hrfilter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adservio.hrfilter.enums.QuestionLevel;
import com.adservio.hrfilter.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	public List<Question> findBySkillAndQuestionLevel(String skill, QuestionLevel level);
}
