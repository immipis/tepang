package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.ProductDAO;

public class GetReviewCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno
				String bno = req.getParameter("bno");
				
				ProductDAO rdao = new ProductDAO();
				String rcount = rdao.selectReplyconut(bno); //댓글건수.
				//{"replyCount": 35}
				resp.getWriter().print("{\"replyCount\":" + rcount + "}");

	}

}
