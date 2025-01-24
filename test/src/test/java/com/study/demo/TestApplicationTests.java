package com.study.demo;

import com.study.demo.sbb.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.demo.sbb.answer.Answer;
import com.study.demo.sbb.answer.AnswerRepository;
import com.study.demo.sbb.question.Question;
import com.study.demo.sbb.question.QuestionRepository;
import com.study.demo.sbb.service.QuestionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@SpringBootTest
class TestApplicationTests {
	
	//@Autowired
	//private QuestionRepository questionRepository;
	//@Autowired
	//private AnswerRepository answerRepository;
	@Autowired
	private QuestionService questionService;
	
	//@Transactional
	@Test
	void testJpa() {
		for	(int i=1; i <= 300; i++) {
			String subject = String.format("테스트 데이터 입니다:[%03d]", i);
			String content = "테스트 상세 내용 넣기";
			this.questionService.saveQuestion(subject, content);
		}
	}

}
