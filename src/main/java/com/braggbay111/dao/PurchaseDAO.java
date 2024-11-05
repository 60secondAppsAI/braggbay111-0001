package com.braggbay111.dao;

import java.util.List;

import com.braggbay111.dao.GenericDAO;
import com.braggbay111.domain.Purchase;





public interface PurchaseDAO extends GenericDAO<Purchase, Integer> {
  
	List<Purchase> findAll();
	






}


