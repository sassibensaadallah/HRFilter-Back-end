package com.adservio.hrfilter.controller;
import java.util.List;

import com.adservio.hrfilter.utils.ApiResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adservio.hrfilter.data.model.Question;
import com.adservio.hrfilter.dto.QuestionDTO;
import com.adservio.hrfilter.service.IQuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	
	@PostMapping(value="/listBySkill")
	public ResponseEntity<Object> getQuestionList(@RequestBody List<String> skillsList) {
		try {
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, true,
							"QUESTION LIST BY SKILLS SUCCESSFULLY GOT",
							this.questionService.getQuestionList(skillsList));
		}catch (Exception e){
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, false,
							e.getMessage(),
							null);
		}
	}
	@DeleteMapping(value="/deleteById/{id}")
	public ResponseEntity<Object>  deleteQuestionById(@PathVariable(name = "id")Long id) {
		try {
			questionService.deleteQuestionById(id);
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, true,
							"QUESTION SUCCESSFULLY DELETED",
							null);
		}catch (Exception e){
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, false,
							e.getMessage(),
							null);
		}
	}
	@GetMapping(value="/getById/{id}")
	public ResponseEntity<Object>getQuestionById(@PathVariable(name = "id")Long id) {
		try {
			Question question=questionService.getQuestionById(id);
			if(question==null)
				return ApiResponseHandler
						.generateResponse(HttpStatus.NOT_FOUND, true,
								"NOT_FOUND",
								null);
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, true,
							"QUESTION WITH ID:"+ id,
							question);
		}catch (Exception e){
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, false,
							e.getMessage(),
							null);
		}
	}
	@PutMapping(value="/editById/{id}")
	public ResponseEntity<Object> editQuestionById(@PathVariable(name = "id") Long id, @RequestBody Question question) {
		try {
			Question question1=questionService.editQuestionById(id,question);
			if(question1!=null) {
				return ApiResponseHandler
						.generateResponse(HttpStatus.NOT_FOUND, true,
								"NOT_FOUND",
								null);
			}
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, true,
							"QUESTION SUCCESSFULLY EDITED",
							question1);

		}catch (Exception e){
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, false,
							e.getMessage(),
							null);
		}
	}
}
