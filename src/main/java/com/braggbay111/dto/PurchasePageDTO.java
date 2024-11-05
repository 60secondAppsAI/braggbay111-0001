package com.braggbay111.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PurchasePageDTO {

	private Integer page = 0;
	private Long totalElements = 0L;

	private List<PurchaseDTO> purchases;
}





