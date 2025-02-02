package com.example.band.Entities.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.band.Entities.Question;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Integer>{

}
