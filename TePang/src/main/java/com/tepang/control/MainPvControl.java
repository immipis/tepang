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

public class MainPvControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String logId = req.getParameter("id");
		
		MainDAO mdao = new MainDAO();
		List<MainVO> products = mdao.addPvList(logId);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(products);
		
		resp.getWriter().write(json);
	}
}
