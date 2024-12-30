package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tepang.common.Control;
import com.tepang.jdbc.TePangDAO;
import com.tepang.vo.MainVO;

public class searchControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		TePangDAO tdao = new TePangDAO();

		String sText = req.getParameter("searchText");
		List<MainVO> lvo = tdao.search(sText);
		
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(lvo);
		resp.getWriter().write(json);
	}

}
