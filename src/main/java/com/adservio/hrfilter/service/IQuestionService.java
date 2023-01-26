package com.adservio.hrfilter.service;

import java.util.List;

import com.adservio.hrfilter.dto.QuestionDTO;

public interface IQuestionService {

	public List<QuestionDTO>  getQuestionList(List<String> skillsList);

}
