package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.entity.Question;

@Service
public class QuestionService {

//	injecting question dao class as dependency inside question service
	@Autowired
	QuestionDao questionDao;

//	returning list of retrieved question to controller 
	public ResponseEntity<List<Question>> getAllQuestions() {

		try {
//			getting all the question from database  using questions dao class 
			List<Question> ls = questionDao.findAll();

			return new ResponseEntity<List<Question>>(ls, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<List<Question>>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);

		}
	}

//	getting questions from db by category
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

		try {
			
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);
			
		}

	}
	
	
//adding question to db 
	public ResponseEntity<String> addQuestion(Question question) {

		try {
			
			questionDao.save(question);
			return new ResponseEntity<String>("question is saved in database", HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<String>("question is not saved in database", HttpStatus.BAD_REQUEST);
			
		}

	}
	
//updating question
	public ResponseEntity<String> updateQuestion(Question question) {
		try {
			
			questionDao.save(question);
			return new ResponseEntity<String>("question updated with id " + question.getId(), HttpStatus.OK);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<String>("question  is not updated with id " + question.getId(),
					HttpStatus.BAD_REQUEST);
			
		}
	}

	public ResponseEntity<String> deleteQuestionById(Integer id) {
		try {
			
			questionDao.deleteById(id);
			return new ResponseEntity<String>("Question deleted of id: " + id, HttpStatus.OK);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<String>("Question  is deleted of id: " + id, HttpStatus.BAD_REQUEST);

		}

	}

}
