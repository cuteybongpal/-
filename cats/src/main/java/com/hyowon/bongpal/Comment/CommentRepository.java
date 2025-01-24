package com.hyowon.bongpal.Comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyowon.bongpal.Poster.Post;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	public List<Comment> findByPost(Post post);
}
