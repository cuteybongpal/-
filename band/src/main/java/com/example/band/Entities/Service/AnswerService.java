package com.example.band.Entities.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.band.Entities.Answer;
import com.example.band.Entities.Question;
import com.example.band.Entities.Repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
	private final AnswerRepository answerRepo;
	
	
	public void create(String content, Question question) {
		Answer a = new Answer();
		a.setContent(content);
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(question);
		this.answerRepo.save(a);
	}
}
