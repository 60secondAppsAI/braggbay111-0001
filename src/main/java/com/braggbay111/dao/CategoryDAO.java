package com.braggbay111.dao;

import java.util.List;

import com.braggbay111.dao.GenericDAO;
import com.braggbay111.domain.Category;





public interface CategoryDAO extends GenericDAO<Category, Integer> {
  
	List<Category> findAll();
	






}


