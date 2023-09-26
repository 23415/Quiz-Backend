package com.example.questions.dao;

import com.example.questions.model.question;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface questionDao extends JpaRepository<question, Integer> {
    List<question> getAllByLevel(String level);
    @Query(value = "SELECT * FROM question q WHERE q.CATEGORY=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<question> findRandomQuestionByCategory(String category, int numQ);
}
