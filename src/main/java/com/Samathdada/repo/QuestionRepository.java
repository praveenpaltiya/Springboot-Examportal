package com.Samathdada.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Samathdada.models.exam.Question;
import com.Samathdada.models.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question,Long>{

	Set<Question> findByQuiz(Quiz quiz);

}
