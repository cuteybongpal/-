package com.study.demo.sbb.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class QuestionForm {

	@NotBlank(message = "제목은 공백일수 없습니다.")
	@Size(max=50)
	private String subject;
	
	@NotBlank(message = "내용은 공백일수 없습니다.")
	private String content;
}
