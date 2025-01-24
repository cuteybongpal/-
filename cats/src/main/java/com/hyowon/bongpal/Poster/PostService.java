package com.hyowon.bongpal.Poster;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository;
	
	public void CreatePost(String content, String subject) {
		Post p = new Post();
		p.setSubject(subject);
		p.setContent(content);
		p.setCreateDate(LocalDateTime.now());
	}
	public List<Post> GetList(){
		return this.postRepository.findAll();
	}
}
