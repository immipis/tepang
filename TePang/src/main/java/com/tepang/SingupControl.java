package com.tepang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.vo.SingupVO;



public class SingupControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		SingupVO sVO = new SingupVO();
		
		boolean singupresult = false;
		sVO.setMemberId(req.getParameter("member_id"));
		sVO.setMemberPw(req.getParameter("member_pw"));
		sVO.setMemberName(req.getParameter("member_name"));
		sVO.setMemberPhone(req.getParameter("member_phone"));
		sVO.setMemberAdr(req.getParameter("member_adr"));
		sVO.setMemberBir(req.getParameter("member_bir"));
		sVO.setMemberGen(req.getParameter("member_gen"));
		sVO.setMemberFv(req.getParameter("member_fv"));
	
//		MemberSingupService memberSingupservice = new MemberSingupService();
//		https://heannim-world.tistory.com/113-- 참고자료
//		singupresult = memberSingupservice.singupMember(sVO);
	}		
}