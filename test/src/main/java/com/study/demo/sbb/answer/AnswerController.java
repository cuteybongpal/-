package com.study.demo.sbb.answer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.demo.sbb.question.Question;
import com.study.demo.sbb.service.AnswerService;
import com.study.demo.sbb.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@PostMapping("/create/{p_id}")
	public String createAnswer(Model model, @PathVariable("p_id") Integer id, @Valid AnswerForm answerform, BindingResult result) {
		if (result.hasErrors()) {
			Question detail = this.questionService.getQuestion(id);
			List<Answer> aList = this.answerService.getAnswer(detail);
			model.addAttribute("question", detail);
			model.addAttribute("answerList", aList);
			model.addAttribute("answerCount", aList.size());
			return "question_detail";
		}
		Question q = this.questionService.getQuestion(id);
		this.answerService.create(answerform.getContent(), q);
		return String.format("redirect:/question/detail/%s", id);
	}
}
