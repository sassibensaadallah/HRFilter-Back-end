package com.adservio.hrfilter.service;

import java.util.List;

import com.adservio.hrfilter.data.model.Question;
import com.adservio.hrfilter.dto.QuestionDTO;

public interface IQuestionService {

	public List<QuestionDTO>  getQuestionList(List<String> skillsList);

	public void deleteQuestionById(Long id);

	public Question getQuestionById(Long id);

	public Question editQuestionById(Long id, Question question);

}
