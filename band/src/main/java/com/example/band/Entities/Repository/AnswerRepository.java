package com.example.band.Entities.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.band.Entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
