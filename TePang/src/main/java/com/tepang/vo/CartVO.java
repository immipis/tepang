package com.tepang.vo;

import lombok.Data;

@Data
public class CartVO{
        private String cartNum;
        private String productCode;
		private String memberId;
		private int productNum;
		private String cartType;
}
