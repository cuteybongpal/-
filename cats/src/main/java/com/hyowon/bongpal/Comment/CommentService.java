package com.hyowon.bongpal.Comment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hyowon.bongpal.Poster.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	
	public void CreateComment(String content, Post post) {
		Comment c = new Comment();
		c.setContent(content);
		c.setCreateDate(LocalDateTime.now());
		c.setPost(post);
		this.commentRepository.save(c);
	}
	
	public List<Comment> getList(Post post){
		return this.commentRepository.findByPost(post);
	}
}
