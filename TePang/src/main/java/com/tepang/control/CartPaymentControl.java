package com.tepang.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tepang.common.Control;
import com.tepang.jdbc.CartDAO;
import com.tepang.vo.CartVO;

public class CartPaymentControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String name = req.getParameter("name");
		String adr = req.getParameter("adr");
		String phone = req.getParameter("phone");
		String request = req.getParameter("request");
		String cnum = req.getParameter("cnum");
		String osum = req.getParameter("osum");
		String memid = req.getParameter("memid");
		
		System.out.println(cnum);
		CartVO cvo = new CartVO();
		
		cvo.setOrderName(name);
		cvo.setOrderAdr(adr);
		cvo.setOrderPhone(phone);
		cvo.setOrderRequest(request);
		cvo.setCartNum(cnum);
		cvo.setOrderSum(Integer.parseInt(osum));
		cvo.setMemberId(memid);
		
		//List<CartVO>
		Gson gson = new GsonBuilder().create();
		String json = "";
		
		Map<String, Object> orderMap = new HashMap<>();
		
		CartDAO cdao = new CartDAO();
		
		
		  if (cdao.insertOrder(cvo)) { orderMap.put("retCode", "OK");
		  orderMap.put("retVal", cvo);
		  
		  json = gson.toJson(orderMap); resp.getWriter().print(json); } 
		  else {
		  resp.getWriter().print("{\"retCode\": \"Fail\"}"); 
		  }
		 
		
		
				

	}

}
