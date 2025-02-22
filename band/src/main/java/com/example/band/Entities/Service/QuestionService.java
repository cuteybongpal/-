package com.example.band.Entities.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.band.Entities.Question;
import com.example.band.Entities.Repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public List<Question> getList(){
		List<Question> list = this.questionRepository.findAll();
		return list;
	}
	
	public void create(String subject, String content) {
		Question question = new Question();
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}
	public Question getQuetion(Integer id) {
		Optional<Question> q = this.questionRepository.findById(id);
		if (q.isPresent())
			return q.get();
		else
			return null;
	}
}
