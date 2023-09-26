package com.example.questions.controller;

import com.example.questions.model.QuestionWrapper;
import com.example.questions.model.Response;
import com.example.questions.model.question;
import com.example.questions.service.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class quizController {

    @Autowired
    quizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String title, @RequestParam int numQ, @RequestParam String category){
        return quizService.createQuiz(title,numQ,category);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.submitQuiz(id, responses);
    }


}
