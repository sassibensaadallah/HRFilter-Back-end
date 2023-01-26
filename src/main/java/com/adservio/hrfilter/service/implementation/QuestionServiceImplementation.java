package com.adservio.hrfilter.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adservio.hrfilter.dto.QuestionDTO;
import com.adservio.hrfilter.enums.QuestionLevel;
import com.adservio.hrfilter.model.Question;
import com.adservio.hrfilter.repository.QuestionRepository;
import com.adservio.hrfilter.service.IQuestionService;

@Service
public class QuestionServiceImplementation implements IQuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public List<QuestionDTO> getQuestionList(List<String> skillsList) {
		List<QuestionDTO> questionDTOList=new ArrayList<QuestionDTO>();
		for(String skill:skillsList) {
			QuestionDTO questionDTOEasy=new QuestionDTO();
			questionDTOEasy.setSkill(skill);
			questionDTOEasy.setQuestionLevel(QuestionLevel.EASY);
			questionDTOEasy.setQuestionList(getQuestionList(skill,QuestionLevel.EASY));;
			questionDTOList.add(questionDTOEasy);
			
			QuestionDTO questionDTOMedium=new QuestionDTO();
			questionDTOMedium.setSkill(skill);
			questionDTOMedium.setQuestionLevel(QuestionLevel.MEDIUM);
			questionDTOMedium.setQuestionList(getQuestionList(skill,QuestionLevel.MEDIUM));;
			questionDTOList.add(questionDTOMedium);
			
			QuestionDTO questionDTOHard=new QuestionDTO();
			questionDTOHard.setSkill(skill);
			questionDTOHard.setQuestionLevel(QuestionLevel.HARD);
			questionDTOHard.setQuestionList(getQuestionList(skill,QuestionLevel.HARD));
			questionDTOList.add(questionDTOHard);
		}
		return questionDTOList;
	}
	private List<Question> getQuestionList(String skill, QuestionLevel level) {
		List<Question> questionList= questionRepository.findBySkillAndQuestionLevel(skill,level);
		return questionList;
	}

}
