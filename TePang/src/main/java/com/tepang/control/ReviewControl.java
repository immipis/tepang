package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tepang.common.Control;
import com.tepang.jdbc.ProductDAO;
import com.tepang.vo.MainVO;

public class ReviewControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/json;charset=utf-8");
			String pno = req.getParameter("pcode");
			String page = req.getParameter("page");
			ProductDAO bdao = new ProductDAO();
			
			List<MainVO> list = bdao.selectProduct(Integer.parseInt(pno), Integer.parseInt(page));
			
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(list);//자바객체 -> json문자열 변환.

			resp.getWriter().print(json);
			System.out.println(json);

	}

	}