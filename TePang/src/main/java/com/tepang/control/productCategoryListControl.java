package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tepang.common.Control;
import com.tepang.jdbc.MainDAO;
import com.tepang.vo.MainVO;

public class productCategoryListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String category = req.getParameter("category");
		System.out.println("category"+category);
		
		MainDAO mdao = new MainDAO();
		List<MainVO> products = null;
		if (category.equals("null") || category.equals("")) {
			products = mdao.addpList();
		}
		else{
			System.out.println("이게 실행됨");
			products = mdao.pCategoryList(category);
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(products);
		resp.getWriter().write(json);
	}

}
