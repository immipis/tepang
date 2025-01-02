package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.vo.CartVO;

public class HeartListAddControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String cnum = req.getParameter("cnum");
		String pcode = req.getParameter("pcode");
		String mid = req.getParameter("mid");
		String ctype = req.getParameter("ctype");
		
		CartVO cvo = new CartVO();
		
		cvo.setCartNum(cnum);
		cvo.setProductCode(pcode);
		cvo.setMemberId(mid);
		cvo.setCartType(ctype);
		
	}

}
