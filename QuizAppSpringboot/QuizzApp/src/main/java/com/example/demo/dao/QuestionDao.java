package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Question;


public interface QuestionDao extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);
	
	
	@Query(value="SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :noofque", nativeQuery = true)
	List<Question> findRandomQueByCategory(String category, int noofque);
	

}
