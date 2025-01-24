package com.study.demo.sbb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.demo.sbb.question.QuestionRepository;
import com.study.demo.sbb.DataNotFoundException;
import com.study.demo.sbb.question.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public List<Question> getList(){
		return this.questionRepository.findAll();
	}
	public Question getQuestion(Integer id) {
		
		Optional<Question> q = this.questionRepository.findById(id);
		if (q.isPresent())
		{
			return q.get();
		}
		else
		{
			throw new DataNotFoundException("Question Entitiy is not found");
		}
	}
	public void saveQuestion(String subject, String content) {
		Question q = new Question();
		q.setContent(content);
		q.setSubject(subject);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
	public void saveQuestion(Question question) {
		this.questionRepository.save(question);
	}
	public Page<Question> getList(int page){
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.questionRepository.findAll(pageable);
	}
}
