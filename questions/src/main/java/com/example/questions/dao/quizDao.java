package com.example.questions.dao;

import com.example.questions.model.Quiz;
import com.example.questions.model.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface quizDao extends JpaRepository<Quiz,Integer> {

}
