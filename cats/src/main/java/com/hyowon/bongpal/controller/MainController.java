package com.hyowon.bongpal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hyowon.bongpal.Comment.Comment;
import com.hyowon.bongpal.Comment.CommentService;
import com.hyowon.bongpal.Poster.PostService;

import lombok.RequiredArgsConstructor;
import com.hyowon.bongpal.Poster.Post;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final CommentService commentService;
	private final PostService postService;
	@GetMapping("/")
	public String index(Model model) {
		return MoveToIndex(model);
	}
	
	@GetMapping("/post")
	public String Post(Model model) {
		return MoveToIndex(model);
	}
	
	String MoveToIndex(Model model) {
		List<Post> posts = this.postService.GetList();
		model.addAttribute("posts", posts);
		return "index";
	}
	@PostMapping(value = "/comment/create/{id}")
	public String PostComment(Model model,@PathVariable("id") Integer id) {
		
		return MoveToIndex(model);
	}
}
