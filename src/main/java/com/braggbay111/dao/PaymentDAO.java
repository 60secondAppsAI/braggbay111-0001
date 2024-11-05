package com.braggbay111.dao;

import java.util.List;

import com.braggbay111.dao.GenericDAO;
import com.braggbay111.domain.Payment;





public interface PaymentDAO extends GenericDAO<Payment, Integer> {
  
	List<Payment> findAll();
	






}


