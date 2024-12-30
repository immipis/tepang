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
import com.tepang.jdbc.ProductDAO;
import com.tepang.vo.BoardVO;

public class AddReviewControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter(bno, replyer, reply)
				resp.setContentType("text/json;charset=utf-8");
				
				String a = req.getParameter("pno");
				String b = req.getParameter("replyer");
				String c = req.getParameter("reply");
				
				BoardVO rv = new BoardVO();
				
				rv.setProductCode(a);
				rv.setMemberId(b);
				rv.setReplyContent(c);
				
				//json문자열 생성
				Gson gson = new GsonBuilder().create();
				String json = "";
				
				//반환되는 값
				Map<String, Object> resultMap = new HashMap<>();
				
				ProductDAO rdao = new ProductDAO();
				if(rdao.insertReply(rv)) {
					//성공했을때
					resultMap.put("retCode","OK");
					resultMap.put("retVal", rv);
					json = gson.toJson(rv);
					
					resp.getWriter().print(json);
				}else {
					resp.getWriter().print("{\"retCodt\" : \"Fail\"}");
				}

	}

}
