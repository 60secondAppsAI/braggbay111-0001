package com.braggbay111.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbay111.domain.Purchase;
import com.braggbay111.dto.PurchaseDTO;
import com.braggbay111.dto.PurchaseSearchDTO;
import com.braggbay111.dto.PurchasePageDTO;
import com.braggbay111.dto.PurchaseConvertCriteriaDTO;
import com.braggbay111.service.GenericService;
import com.braggbay111.dto.common.RequestDTO;
import com.braggbay111.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PurchaseService extends GenericService<Purchase, Integer> {

	List<Purchase> findAll();

	ResultDTO addPurchase(PurchaseDTO purchaseDTO, RequestDTO requestDTO);

	ResultDTO updatePurchase(PurchaseDTO purchaseDTO, RequestDTO requestDTO);

    Page<Purchase> getAllPurchases(Pageable pageable);

    Page<Purchase> getAllPurchases(Specification<Purchase> spec, Pageable pageable);

	ResponseEntity<PurchasePageDTO> getPurchases(PurchaseSearchDTO purchaseSearchDTO);
	
	List<PurchaseDTO> convertPurchasesToPurchaseDTOs(List<Purchase> purchases, PurchaseConvertCriteriaDTO convertCriteria);

	PurchaseDTO getPurchaseDTOById(Integer purchaseId);







}





