package com.tepang.vo;

import lombok.Data;

@Data
public class OrderVO {
	private String orderNum;
	private String memberId;
	private String productCode;
	private int orderSum;
}
