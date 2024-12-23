package com.tepang.vo;

import lombok.Data;

@Data
public class OrderVO {
	private String cartNum;
	private String memberId;
	private String orderContent;
	private int orderSum;
	private String memberTier;
}
