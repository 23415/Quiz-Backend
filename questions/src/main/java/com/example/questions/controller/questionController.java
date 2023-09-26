package com.example.questions.controller;

import com.example.questions.model.question;
import com.example.questions.service.questionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class questionController {

    @Autowired
    questionService questionService;

    @PostMapping("/addQuestion")
    public ResponseEntity<question> addQuestion(@RequestBody question q){
        return questionService.addQuestion(q);
    }
    @GetMapping("/viewAll")
    public ResponseEntity<List<question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("/viewByLevel/{level}")
    public ResponseEntity<List<question>> getAllByLevel(@PathVariable String level){
        return questionService.getAllByLevel(level);
    }

}
