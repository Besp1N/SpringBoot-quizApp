package com.kacper.quizz.service;

import com.kacper.quizz.model.Question;
import com.kacper.quizz.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService
{
    final QuestionDAO questionDAO;

    @Autowired
    public QuestionService(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    public ResponseEntity<List<Question>>getAllQuestions() {
        return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDAO.save(question);
        return "success";
    }
}
