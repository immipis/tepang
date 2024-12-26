package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.TePangDAO;
import com.tepang.vo.SingupVO;

//https://heannim-world.tistory.com/113-- 참고자료
public class SingupControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String adr = req.getParameter("adr");
		String bir = req.getParameter("bir");
		String gen = req.getParameter("gen");
		String fv = req.getParameter("fv");

	

		if (id == null || id.trim().isEmpty() || pw == null || pw.trim().isEmpty() || name == null
				|| name.trim().isEmpty() || phone == null || phone.trim().isEmpty() || adr == null
				|| adr.trim().isEmpty() || bir == null || bir.trim().isEmpty() || gen == null || gen.trim().isEmpty()
				|| fv == null || fv.trim().isEmpty()) {
			req.setAttribute("error", "올바르게 입력하시오.");
			req.getRequestDispatcher("WEB-INF/html/Singup.jsp").forward(req, resp);

		}

		SingupVO singup = new SingupVO();

		singup.setMemberId(id);
		singup.setMemberPw(pw);
		singup.setMemberName(name);
		singup.setMemberPhone(phone);
		singup.setMemberAdr(adr);
		singup.setMemberBir(bir);
		singup.setMemberGen(gen);
		singup.setMemberFv(fv);

		
		TePangDAO tdao = new TePangDAO();
		boolean isSingup = tdao.insertSignup(singup);
		if (isSingup) {
			 resp.sendRedirect(req.getContextPath());
		} else {
			req.setAttribute("error", "회원가입 실패");
			req.getRequestDispatcher("WEB-INF/html/Singup.jsp").forward(req, resp);
		}
	

	}
}