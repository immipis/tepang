package com.tepang.vo;

import lombok.Data;

@Data
public class OrderVO {
	private String cartNum;
	private int orderSum;
	private String memberId;
	private String orderDay;
	private String orderNo;
	private String orderAdr;
	private String orderName;
	private String orderPhone;
	private String orderRequest;
	private String productName;
	private String productImg;
}
