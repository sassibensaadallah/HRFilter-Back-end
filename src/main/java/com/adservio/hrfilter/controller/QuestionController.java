package com.adservio.hrfilter.controller;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adservio.hrfilter.dto.QuestionDTO;
import com.adservio.hrfilter.service.IQuestionService;

import ch.qos.logback.classic.Logger;


@RestController
@RequestMapping("/question")
public class QuestionController {
	Logger logger = (Logger) LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	private IQuestionService questionService;
	@GetMapping(value="/listBySkill")
	public List<QuestionDTO> getQuestionList(@RequestBody List<String> skillsList) {
		List<QuestionDTO> listQuestionDTO=this.questionService.getQuestionList(skillsList);
		return listQuestionDTO;
	}
}
