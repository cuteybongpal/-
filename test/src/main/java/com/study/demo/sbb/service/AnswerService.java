package com.study.demo.sbb.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.demo.sbb.DataNotFoundException;
import com.study.demo.sbb.answer.Answer;
import com.study.demo.sbb.answer.AnswerRepository;
import com.study.demo.sbb.question.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public void create(String content, Question question) {
		Answer answer = new Answer();
		
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		this.answerRepository.save(answer);
	}
	
	public List<Answer> getList(){
		return this.answerRepository.findAll();
	}
	public List<Answer> getAnswer(Question question){
		List<Answer> q = this.answerRepository.findByQuestion(question);
		return q;		
	}
}
