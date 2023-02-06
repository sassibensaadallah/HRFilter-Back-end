package com.adservio.hrfilter.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adservio.hrfilter.data.model.Question;
import com.adservio.hrfilter.dto.QuestionDTO;
import com.adservio.hrfilter.enums.QuestionLevel;
import com.adservio.hrfilter.repository.QuestionRepository;
import com.adservio.hrfilter.service.IQuestionService;

@Service
public class QuestionServiceImplementation implements IQuestionService {
	Random r=new Random();

	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public List<QuestionDTO> getQuestionList(List<String> skillsList) {
		List<QuestionDTO> questionDTOList=new ArrayList<QuestionDTO>();
		for(String skill:skillsList) {
			
			List<Question> easyQuestion=getQuestionList(skill,QuestionLevel.EASY);
			if(easyQuestion!=null && !easyQuestion.isEmpty()) {
				QuestionDTO questionDTOEasy=new QuestionDTO();
				questionDTOEasy.setSkill(skill);
				questionDTOEasy.setQuestionLevel(QuestionLevel.EASY);
				questionDTOEasy.setQuestionList(easyQuestion);
				questionDTOList.add(questionDTOEasy);
			}
			List<Question> mediumQuestion=getQuestionList(skill,QuestionLevel.MEDIUM);
			if(mediumQuestion!=null && !mediumQuestion.isEmpty()) {
				QuestionDTO questionDTOMedium=new QuestionDTO();
				questionDTOMedium.setSkill(skill);
				questionDTOMedium.setQuestionLevel(QuestionLevel.MEDIUM);
				questionDTOMedium.setQuestionList(mediumQuestion);
				questionDTOList.add(questionDTOMedium);
			}
			List<Question> hardQuestion=getQuestionList(skill,QuestionLevel.HARD);
			if(hardQuestion!=null && !hardQuestion.isEmpty()) {
				QuestionDTO questionDTOHard=new QuestionDTO();
				questionDTOHard.setSkill(skill);
				questionDTOHard.setQuestionLevel(QuestionLevel.HARD);
				questionDTOHard.setQuestionList(hardQuestion);
				questionDTOList.add(questionDTOHard);
			}
		}
		return questionDTOList;
	}
	private List<Question> getQuestionList(String skill, QuestionLevel level) {
		List<Question> questionList= questionRepository.findBySkillIgnoreCaseAndQuestionLevel(skill,level);
		if (questionList.size()>3) {
			int random= r.nextInt(questionList.size()-3);
			return questionList.subList(random, random+3);
		}
		return questionList;
	}
	@Override
	public void deleteQuestionById(Long id) {
		this.questionRepository.deleteById(id);
	}
	@Override
	public Question getQuestionById(Long id) {
		Optional<Question> questionOptional=questionRepository.findById(id);
		return questionOptional.orElse(null);
	}
	@Override
	public Question editQuestionById(Long id,Question question) {
		questionRepository.deleteById(id);
		return questionRepository.save(question);
	}

}
