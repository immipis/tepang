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

public class InsertCartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String pcode = req.getParameter("pcode");
		String memid = req.getParameter("memid");
		String pnum = req.getParameter("pnum");
		
		CartVO cvo = new CartVO();
		cvo.setProductCode(pcode);
		cvo.setMemberId(memid);
		cvo.setProductNum(Integer.parseInt(pnum));
		
		Gson gson = new GsonBuilder().create();
		String json = "";
		
		Map<String, Object> cartMap = new HashMap<>();
		
		CartDAO cdao = new CartDAO();
		
		if (cdao.insertCart(cvo)) {
			cartMap.put("retCode", "OK");
			cartMap.put("retVal", cvo);
			
			json = gson.toJson(cartMap);
			resp.getWriter().print(json);
		} else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}

}
