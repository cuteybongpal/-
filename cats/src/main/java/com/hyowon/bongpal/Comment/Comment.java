package com.hyowon.bongpal.Comment;

import java.time.LocalDateTime;

import com.hyowon.bongpal.Poster.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Comment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(columnDefinition = "TEXT")
    private String content;
    
    private LocalDateTime createDate;
    
    @ManyToOne
    private Post post; // 올바른 Question 엔티티 참조
}
