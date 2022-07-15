package com.Samathdada.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Samathdada.models.exam.Category;
import com.Samathdada.models.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long>{
	
	public List<Quiz> findBycategory(Category category);
	
	public List<Quiz> findByActive(boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category c,boolean b);
	

}
