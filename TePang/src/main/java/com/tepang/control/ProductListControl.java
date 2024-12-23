package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.MainDAO;
import com.tepang.vo.MainVO;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
		String boardList = req.getParameter("boardList");
		System.out.println(title);
//		MainDAO mdao = new MainDAO();
//		List<MainVO> products2 = mdao.pList(title);
//		
		req.setAttribute("title", title);
		req.setAttribute("boardList", boardList);
//		req.setAttribute("products2", products2);
		req.getRequestDispatcher("WEB-INF/html/productList.jsp").forward(req, resp);

	}

}
