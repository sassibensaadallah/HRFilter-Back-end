package com.adservio.hrfilter.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity

public class Response {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long responseId;
	private String responseText;
	@ManyToOne()
    @JoinColumn(name="questionId")
	private Question question;
	public Long getResponseId() {
		return responseId;
	}
	public String getResponseText() {
		return responseText;
	}
}
