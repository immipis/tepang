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

public class InsertLikeControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/json;charset=utf-8");
		
		String pcode = req.getParameter("pcode");
		String memid = req.getParameter("memid");
		
		CartVO cvo = new CartVO();
		
		cvo.setProductCode(pcode);
		cvo.setMemberId(memid);
		
		Gson gson = new GsonBuilder().create();
		String json = "";
		
		Map<String, Object> likeMap = new HashMap<>();
		
		CartDAO cdao = new CartDAO();
		
		if (cdao.insertLike(cvo)) {
			likeMap.put("retCode", "OK");
			likeMap.put("retVal", cvo);
			
			
			json = gson.toJson(likeMap);
			resp.getWriter().print(json);
		} else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}
		
	}
