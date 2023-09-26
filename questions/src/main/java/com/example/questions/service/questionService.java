package com.example.questions.service;

import com.example.questions.controller.questionController;
import com.example.questions.dao.questionDao;
import com.example.questions.model.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class questionService {
    @Autowired
    questionDao questionDao;

    public ResponseEntity<List<question>> getAllQuestion(){
        try {
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }catch (Error e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<question> addQuestion(question q) {
        try {
            return new ResponseEntity<>(questionDao.save(q), HttpStatus.CREATED);
        }catch (Error e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new question(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<question>> getAllByLevel(String level) {
        try {
            return new ResponseEntity<>(questionDao.getAllByLevel(level),HttpStatus.OK);
        }catch (Error e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

}
