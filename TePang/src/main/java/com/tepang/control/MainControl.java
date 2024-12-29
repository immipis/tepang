package com.tepang.control;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tepang.common.Control;
import com.tepang.jdbc.MainDAO;
import com.tepang.vo.MainVO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		MainDAO mdao = new MainDAO();
		
		int page = 1;
		try {
		    page = Integer.parseInt(req.getParameter("page"));
		} catch (NumberFormatException e) {
		    // page 파라미터가 없는 경우 기본값으로 1
		}

		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("member_id");
		
		List<MainVO> products = null;
		if (id == null || id == "null" || id.equals(" ") || id.equals("")) {
			products = mdao.addpList(page);
		} else {
			products = mdao.addPvList(id,page);
		}
		req.setAttribute("currentPage", page);
		req.setAttribute("products", products);
		req.getRequestDispatcher("WEB-INF/html/main.jsp").forward(req, resp);

//		Gson gson = new GsonBuilder().create();
//		String json = gson.toJson(products);
//		
//		resp.getWriter().write(json);
	}

}
