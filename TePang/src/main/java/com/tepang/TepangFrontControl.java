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
import com.tepang.control.BoardControl;
import com.tepang.control.BoardListControl;

public class TepangFrontControl extends HttpServlet{
	Map<String, Control> map;
	
	public TepangFrontControl() {
		map = new HashMap<>(); // 필드의 값을 초기화.
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl()); // 게시판목록
		map.put("/board.do", new BoardControl()); //게시판목록 > 상세
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http://localhost:80/BoardWeb/boardList.do
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
