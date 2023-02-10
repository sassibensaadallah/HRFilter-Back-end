package com.adservio.hrfilter.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adservio.hrfilter.data.model.Question;
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
	@DeleteMapping(value="/deleteById/{id}")
	public void deleteQuestionById(@PathVariable(name = "id")Long id) {
		questionService.deleteQuestionById(id);
	}
	@GetMapping(value="/getById/{id}")
	public ResponseEntity<Question>getQuestionById(@PathVariable(name = "id")Long id) {
		Question question=questionService.getQuestionById(id);
		if(question==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Question>(question,HttpStatus.OK);
	}
	@PutMapping(value="/editById/{id}")
	public ResponseEntity<Question> editQuestionById(@PathVariable(name = "id") Long id, @RequestBody Question question) {
		Question question1=questionService.editQuestionById(id,question);
		if(question1!=null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Question>(question1,HttpStatus.OK);
	}
}
