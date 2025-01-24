package com.hyowon.bongpal;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyowon.bongpal.Comment.Comment;
import com.hyowon.bongpal.Comment.CommentRepository;
import com.hyowon.bongpal.Poster.Post;
import com.hyowon.bongpal.Poster.PostRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class CatsApplicationTests {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	@Test
	void contextLoads() {
		Post p = new Post();
		p.setContent("dfafadf");
		p.setSubject("dafadfaf");
		p.setCreateDate(LocalDateTime.now());
		this.postRepository.save(p);
		
		Comment c = new Comment();
		c.setContent("dafadfadf");
		c.setCreateDate(LocalDateTime.now());
		c.setPost(p);
		commentRepository.save(c);
		
	}

}
