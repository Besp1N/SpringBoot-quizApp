package com.kacper.quizz.service;

import com.kacper.quizz.dao.QuestionDAO;
import com.kacper.quizz.dao.QuizDao;
import com.kacper.quizz.model.Question;
import com.kacper.quizz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService
{
    final QuizDao quizDao;
    final QuestionDAO questionDao;

    @Autowired
    public QuizService(QuizDao quizDao, QuestionDAO questionDao) {
        this.quizDao = quizDao;
        this.questionDao = questionDao;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
