package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tepang.common.Control;
import com.tepang.jdbc.CartDAO;

public class CartCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        CartDAO cdao = new CartDAO();
        
		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("member_id");
		
		int a = cdao.Count(id);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(a);
		resp.getWriter().write(json);
		
	}

}
