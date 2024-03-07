package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.dao.QuizDao;
import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionWrapper;
import com.example.demo.entity.Quiz;
import com.example.demo.entity.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int noofque, String title) {

		List<Question> questions = questionDao.findRandomQueByCategory(category, noofque);

		Quiz q = new Quiz();
		
		q.setTitle(title);
		q.setQuestions(questions);

		quizDao.save(q);

		return new ResponseEntity<>("success", HttpStatus.CREATED);

	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		
//				Optional<Quiz> quiz = quizDao.findById(id); or below
		       Quiz quiz = quizDao.findById(id).get();
				
				List<Question> queFromDb=quiz.getQuestions();
				
				List<QuestionWrapper> ls=new ArrayList<>();
				for(Question q: queFromDb)
				{
					 QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionText(), q.getOption1(),q.getOption2(), q.getOption3(), q.getOption4());
						ls.add(qw);
				}
				
				return new ResponseEntity<List<QuestionWrapper>>(ls,HttpStatus.OK);			
			  
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		
		Quiz quiz=quizDao.findById(id).get();
		
		List<Question> questions = quiz.getQuestions();
		int i=0;
		int marks=0;
	
		for(Response res:responses)
		{
//			if(res.getResponse().equals(questions.get(i).getCorrectOption()))
			if(questions.get(i).getCorrectOption().equals(res.getResponse()))
				marks++;
			
			i++;
		}
		return new ResponseEntity<>(marks,HttpStatus.OK);
	}

	
}
