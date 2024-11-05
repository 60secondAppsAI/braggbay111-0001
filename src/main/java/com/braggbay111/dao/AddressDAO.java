package com.braggbay111.dao;

import java.util.List;

import com.braggbay111.dao.GenericDAO;
import com.braggbay111.domain.Address;





public interface AddressDAO extends GenericDAO<Address, Integer> {
  
	List<Address> findAll();
	






}


