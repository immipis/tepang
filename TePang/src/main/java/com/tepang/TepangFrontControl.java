package com.tepang;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;


import com.tepang.control.CartFormControl;
import com.tepang.control.CartListControl;

import com.tepang.control.BoardControl;
import com.tepang.control.BoardListControl;

import com.tepang.control.TepangLoginControl;
import com.tepang.control.TepangLoginFormControl;
import com.tepang.control.TepangLogoutControl;


public class TepangFrontControl extends HttpServlet {

	Map<String, Control> map;

	public TepangFrontControl() {
		map = new HashMap<>(); // 필드의 값을 초기화.
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		map.put("/cartList.do", new CartListControl());

		map.put("/boardList.do", new BoardListControl()); // 게시판목록
		map.put("/board.do", new BoardControl()); // 게시판목록 > 상세
		// 로그인 및 로그아웃

		map.put("/tepnagloginForm.do", new TepangLoginFormControl());
		map.put("/tepanglogin.do", new TepangLoginControl());
		map.put("/tepanglogout.do/", new TepangLogoutControl());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http://localhost:80/BoardWeb/boardList.do
		System.out.println("12351565");
		String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path); // "/boardList.do" 공통부분을 제외한 나머지 부분.

		// 요청url === 실행할 컨트롤
		Control control = map.get(path);
		control.exec(req, resp);
	}
}
