package com.example.questions.service;

import com.example.questions.dao.quizDao;
import com.example.questions.dao.questionDao;
import com.example.questions.model.QuestionWrapper;
import com.example.questions.model.Quiz;
import com.example.questions.model.Response;
import com.example.questions.model.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService {

    @Autowired
    quizDao quizDao;
    @Autowired
    questionDao questionDao;
    public ResponseEntity<String> createQuiz(String title, int numQ, String category) {
        try {
            Quiz q = new Quiz();
            List<question> question = questionDao.findRandomQuestionByCategory(category,numQ);
            q.setTitle(title);
            q.setQuestion(question);
            quizDao.save(q);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Error e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("unsuccessfull", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<question> questionFromDb = quiz.get().getQuestion();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (question q : questionFromDb){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionName(),q.getOption1(),
                    q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<question> question = quiz.getQuestion();
        int score = 0,idx=0;
        for(Response res : responses){
            if(res.getResponse().equals(question.get(idx).getCorrectAnswer()))score++;
            idx++;
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
