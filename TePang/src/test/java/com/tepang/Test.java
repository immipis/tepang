package com.tepang;

import java.util.List;

import com.tepang.jdbc.CartDAO;
import com.tepang.vo.CartVO;

public class Test {
	public static void main(String[] args) {
		CartDAO cdao = new CartDAO();
		List<CartVO> clist = cdao.cartList("user02", "장바구니");
	System.out.println(clist);
	}
	
}
