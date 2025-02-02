package com.example.band;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.band.Entities.Answer;
import com.example.band.Entities.Question;
import com.example.band.Entities.Repository.AnswerRepository;
import com.example.band.Entities.Repository.QuestionRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class BandApplicationTests {
	
	@Autowired
	private QuestionRepository qRepository;
	@Autowired
	private AnswerRepository aRepository;
	
	@Test
	void contextLoads() {
		Question q = new Question();
		q.setSubject("제목이에요");
		q.setContent("아 내용이에요");
		q.setCreateDate(LocalDateTime.now());
		
		
		Answer a = new Answer();
		a.setContent("댓글1");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		this.qRepository.save(q);
		this.aRepository.save(a);
	}

}

