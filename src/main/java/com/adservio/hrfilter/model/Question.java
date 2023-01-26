package com.adservio.hrfilter.model;

import java.util.ArrayList;
import java.util.List;


import com.adservio.hrfilter.enums.QuestionLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long questionId;
	private String questionText;
	@JsonIgnore
	private String skill;
	@JsonIgnore
	private QuestionLevel questionLevel;
	private int raiting;
	
	@OneToMany(mappedBy="question",fetch = FetchType.EAGER)
	private List<Response> responseList=new ArrayList<>();

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

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

	public int getRaiting() {
		return raiting;
	}

	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}

	public List<Response> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<Response> responseList) {
		this.responseList = responseList;
	}
	
	

}
