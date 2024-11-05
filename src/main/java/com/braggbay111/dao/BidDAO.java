package com.braggbay111.dao;

import java.util.List;

import com.braggbay111.dao.GenericDAO;
import com.braggbay111.domain.Bid;





public interface BidDAO extends GenericDAO<Bid, Integer> {
  
	List<Bid> findAll();
	






}


