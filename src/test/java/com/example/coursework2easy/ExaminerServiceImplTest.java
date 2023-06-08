package com.example.coursework2easy;

import com.example.coursework2easy.exceptions.ChooseFewerQuestionsException;
import com.example.coursework2easy.model.Question;
import com.example.coursework2easy.services.ExaminerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;


    @Test
    public void getQuestionTest() {

        Question question = new Question("q1", "a1");
        Question question2 = new Question("q2", "a2");
        Question question3 = new Question("q3", "a3");
        Question question4 = new Question("q4", "a4");
        Question question5 = new Question("q5", "a5");

        Collection<Question> questions1 = Arrays.asList(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3"),
                new Question("q4", "a4"),
                new Question("q5", "a5"),
                new Question("q6", "a6")
        );
        Mockito.when(questionService.getAll()).thenReturn(questions1);

        Mockito.when(questionService.getRandomQuestion())
                .thenReturn(question)
                .thenReturn(question2)
                .thenReturn(question3)
                .thenReturn(question4)
                .thenReturn(question5);

        Collection<Question> actual = examinerServiceImpl.getQuestions(5);

        Assertions.assertThat(actual.size()).isEqualTo(5);
        Assertions.assertThat(actual).contains(
                question, question2, question3, question4, question5
        );


    }
    @Test
    public void getQuestionNegativeTest() {
        Collection<Question> questions1 = Arrays.asList(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3"),
                new Question("q4", "a4"),
                new Question("q5", "a5"),
                new Question("q6", "a6")
        );
        Mockito.when(questionService.getAll()).thenReturn(questions1);


        org.junit.jupiter.api.Assertions.assertThrows(ChooseFewerQuestionsException.class, () -> examinerServiceImpl.getQuestions(10));
    }

}
