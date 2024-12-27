package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.ProductDAO;

public class RemoveReviewControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//리뷰 삭제
		String rno = req.getParameter("rno");
		
		ProductDAO rdao = new ProductDAO();
		if(rdao.deleteReply(Integer.parseInt(rno))) {
			//{"retCode" : "OK"}
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else {
			//{"retCodt" : "Fail"}
			resp.getWriter().print("{\"retCodt\" : \"Fail\"}");
		}
	}

}
