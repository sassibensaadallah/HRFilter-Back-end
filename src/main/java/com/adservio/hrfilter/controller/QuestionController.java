package com.adservio.hrfilter.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adservio.hrfilter.dto.QuestionDTO;
import com.adservio.hrfilter.service.IQuestionService;



@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	
	@PostMapping(value="/listBySkill")
	public List<QuestionDTO> getQuestionList(@RequestBody List<String> skillsList) {
		List<QuestionDTO> listQuestionDTO=this.questionService.getQuestionList(skillsList);
		return listQuestionDTO;
	}
}
