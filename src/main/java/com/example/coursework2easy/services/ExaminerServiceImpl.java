package com.example.coursework2easy.services;

import com.example.coursework2easy.ExaminerService;
import com.example.coursework2easy.model.Question;
import com.example.coursework2easy.QuestionService;
import com.example.coursework2easy.exceptions.ChooseFewerQuestionsException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> set = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new ChooseFewerQuestionsException("choose fewer questions");
        }

//        for (int i = 0; i < amount; i++) {
//            Question question = questionService.getRandomQuestion();
//            if (set.contains(question)) {
//                i -= 1;
//            } else {
//                set.add(question);
//            }
//        }
        int ii = 0;
        while (ii < amount) {
            Question question = questionService.getRandomQuestion();
            if (!set.contains(question)) {
                set.add(question);
                ii += 1;
            }
        }

        return set;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExaminerServiceImpl that = (ExaminerServiceImpl) o;
        return Objects.equals(questionService, that.questionService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionService);
    }
}
