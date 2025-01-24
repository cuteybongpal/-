package com.study.demo.sbb.answer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.demo.sbb.question.Question;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	public List<Answer> findByQuestion(Question question);
}
