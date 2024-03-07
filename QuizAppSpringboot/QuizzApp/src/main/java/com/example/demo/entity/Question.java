package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "questions")
//@Data
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String questionText;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctOption;
	private int marks;
	private String category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionText=" + questionText + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", correctOption=" + correctOption + ", marks="
				+ marks + ", category=" + category + "]";
	}

	public Question(Integer id, String questionText, String option1, String option2, String option3, String option4,
			String correctOption, int marks, String category) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctOption = correctOption;
		this.marks = marks;
		this.category = category;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

}
