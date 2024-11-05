package com.braggbay111.dao;

import java.util.List;

import com.braggbay111.dao.GenericDAO;
import com.braggbay111.domain.Feedback;





public interface FeedbackDAO extends GenericDAO<Feedback, Integer> {
  
	List<Feedback> findAll();
	






}


