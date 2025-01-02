package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;
import com.tepang.jdbc.MyPageDAO;
import com.tepang.vo.CartVO;
import com.tepang.vo.SingupVO;

public class MyHeartListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyPageDAO mpdo = new MyPageDAO();
		HttpSession session = req.getSession();
		String mid = (String) session.getAttribute("member_id");		
		SingupVO svo = mpdo.selectMember(mid); 
		req.setAttribute("memId", svo);
		
		String type = req.getParameter("type");
		type = (type == null ? "찜" : type);
		
		MyPageDAO mpdao = new MyPageDAO();
		List<CartVO> clist = mpdao.selectMyHeart(type, mid);
		
		req.setAttribute("list", clist);
		req.getRequestDispatcher("WEB-INF/html/myheartlist.jsp").forward(req, resp);	

	}

}
