package com.study.demo.sbb.answer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	@NotBlank(message = "공백은 허용되지 않습니다.")
	private String content;
}
