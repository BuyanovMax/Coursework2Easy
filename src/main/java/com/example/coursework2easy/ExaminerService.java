package com.example.coursework2easy;

import com.example.coursework2easy.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
