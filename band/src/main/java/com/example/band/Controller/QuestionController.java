package com.example.band.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.band.Entities.Question;
import com.example.band.Entities.Form.AnswerForm;
import com.example.band.Entities.Form.QuestionForm;
import com.example.band.Entities.Service.AnswerService;
import com.example.band.Entities.Service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QuestionController {
	
	private final AnswerService answerService;
	private final QuestionService questionService;
	
	@GetMapping("")
	public String main(Model model, AnswerForm answerForm, QuestionForm questionForm) {
		List<Question> list = this.questionService.getList();
		model.addAttribute("questions", list);
	 	return "index";
	}
	
	@PostMapping("/question/create")
	public String createQuestion(Model model, @Valid QuestionForm form, BindingResult result, AnswerForm answerForm, QuestionForm questionForm) {
		System.out.println("ㅁㄴㅇ라ㅓㅁㅇ니;ㅏㅓㅁㅇㄴ래ㅣ;ㅏㅓㅁㄹㅇㄴ ;ㅣㅐㅓㅏㅗㅁㅇㅈ");
		this.questionService.create(form.getSubject(), form.getContent());
		return MoveToIndex();
	}
	protected String MoveToIndex() {
		return "redirect:/";
	}
}
