package com.Samathdada.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Samathdada.models.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	

}
