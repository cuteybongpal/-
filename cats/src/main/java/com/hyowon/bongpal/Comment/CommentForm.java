package com.hyowon.bongpal.Comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentForm {

	@NotBlank(message = "공백은 허용되지 않습니다.")
	private String content;
}
