package com.adservio.hrfilter.dto;
import java.util.ArrayList;
import java.util.List;

import com.adservio.hrfilter.data.model.Question;
import com.adservio.hrfilter.enums.QuestionLevel;

public class QuestionDTO {
	private String skill;
	private QuestionLevel questionLevel;
	private List<Question> questionList=new ArrayList<>();
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public QuestionLevel getQuestionLevel() {
		return questionLevel;
	}
	public void setQuestionLevel(QuestionLevel questionLevel) {
		this.questionLevel = questionLevel;
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	
}
