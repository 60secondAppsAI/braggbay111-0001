package com.braggbay111.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.braggbay111.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.braggbay111.domain.Purchase;
import com.braggbay111.dto.PurchaseDTO;
import com.braggbay111.dto.PurchaseSearchDTO;
import com.braggbay111.dto.PurchasePageDTO;
import com.braggbay111.service.PurchaseService;
import com.braggbay111.dto.common.RequestDTO;
import com.braggbay111.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/purchase")
@RestController
public class PurchaseController {

	private final static Logger logger = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	PurchaseService purchaseService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Purchase> getAll() {

		List<Purchase> purchases = purchaseService.findAll();
		
		return purchases;	
	}

	@GetMapping(value = "/{purchaseId}")
	@ResponseBody
	public PurchaseDTO getPurchase(@PathVariable Integer purchaseId) {
		
		return (purchaseService.getPurchaseDTOById(purchaseId));
	}

 	@RequestMapping(value = "/addPurchase", method = RequestMethod.POST)
	public ResponseEntity<?> addPurchase(@RequestBody PurchaseDTO purchaseDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = purchaseService.addPurchase(purchaseDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/purchases")
	public ResponseEntity<PurchasePageDTO> getPurchases(PurchaseSearchDTO purchaseSearchDTO) {
 
		return purchaseService.getPurchases(purchaseSearchDTO);
	}	

	@RequestMapping(value = "/updatePurchase", method = RequestMethod.POST)
	public ResponseEntity<?> updatePurchase(@RequestBody PurchaseDTO purchaseDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = purchaseService.updatePurchase(purchaseDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
