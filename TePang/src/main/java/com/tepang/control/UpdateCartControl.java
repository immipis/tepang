package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tepang.common.Control;
import com.tepang.jdbc.CartDAO;
import com.tepang.vo.CartVO;

public class UpdateCartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pnum = req.getParameter("pnum");
		String memid = req.getParameter("memid");
		String pcode = req.getParameter("pcode");
		
		CartVO cvo = new CartVO();
		
		
		
		cvo.setProductNum(Integer.parseInt(pnum));
		cvo.setMemberId(memid);
		cvo.setProductCode(pcode);
		 
		
		CartDAO cdao = new CartDAO();
		
		boolean ucart = cdao.updateCart(cvo);
	
		
		Gson gson = new GsonBuilder().create(); 
		
		String json = gson.toJson(ucart);
		  
		resp.getWriter().write(json);
		
	
	}

}
