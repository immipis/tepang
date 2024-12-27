package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.ProductDAO;
import com.tepang.vo.MainVO;

public class ProductDetailControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductDAO bdao = new ProductDAO();

		String pno = req.getParameter("pcode");

		List<MainVO> bvo = bdao.selectProduct(pno);
		req.setAttribute("product", bvo);

		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);

	}

}
