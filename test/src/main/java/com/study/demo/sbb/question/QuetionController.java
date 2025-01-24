package com.study.demo.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.demo.sbb.answer.Answer;
import com.study.demo.sbb.answer.AnswerForm;
import com.study.demo.sbb.service.AnswerService;
import com.study.demo.sbb.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuetionController {
	
	//private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@GetMapping("/list")
	public String getQuestionList(Model model, @RequestParam(value ="page", defaultValue = "0") int page){
		Page<Question> paging = this.questionService.getList(page);
		
		model.addAttribute("paging", paging);
		return "question_list";
	}
	
	@GetMapping(value = "/detail/{P_id}")
	public String detail(Model model,  @PathVariable("P_id") Integer id, AnswerForm answerForm) {
		Question detail = this.questionService.getQuestion(id);
		List<Answer> aList = this.answerService.getAnswer(detail);
		model.addAttribute("question", detail);
		model.addAttribute("answerList", aList);
		model.addAttribute("answerCount", aList.size());
		return "question_detail";
	}
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		return "question_create";
	}
	
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult result) {
		
		if (result.hasErrors())
		{
			return "question_create";
		}
		Question q = new Question();
		q.setSubject(questionForm.getSubject());
		q.setContent(questionForm.getSubject());
		q.setCreateDate(LocalDateTime.now());
		this.questionService.saveQuestion(q);
		return "redirect:/question/list";
	}
}
