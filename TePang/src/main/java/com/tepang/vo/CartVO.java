package com.tepang.vo;

import lombok.Data;

@Data
public class CartVO{
	    private String productCode;
        private String productName;
        private String productImg;
		private String memberId;
		private String cartType;
		private String cartNum;
		private int productNum;
		private int productPrice;
        private int orderSum;

        private String category;
        private String orderAdr;
        private String orderName;
        private String orderPhone;
        private String orderRequest;
        private String orderNo;
        

}
