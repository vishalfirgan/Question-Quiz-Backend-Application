package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionWrapper;
import com.example.demo.entity.Response;
import com.example.demo.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

//injected the dependency of quiz service class using autowired
	@Autowired
	QuizService quizService;

//	http://localhost:8080/quiz/create?category=sql&noofque=5&title=sqlquiz
//	this method will be responsible for creating quiz by taking category no of questions and title from request parameters
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer noofque,
			@RequestParam String title) {

		return quizService.createQuiz(category, noofque, title);

	}

//	this method will be returning list of all questions from particular quiz by id
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
		return quizService.getQuizQuestions(id);
	}

//	http://localhost:8080/quiz/submit/1
//	here we submitting the quiz 
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
		return quizService.calculateResult(id, responses);
	}

}
