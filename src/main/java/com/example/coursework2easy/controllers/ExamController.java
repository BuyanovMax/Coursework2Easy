package com.example.coursework2easy.controllers;

import com.example.coursework2easy.ExaminerService;
import com.example.coursework2easy.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("exam/java")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/getQuestions")
    Collection<Question> getQuestions(@RequestParam("amount")int amount) {
        return examinerService.getQuestions(amount);
    }


}
