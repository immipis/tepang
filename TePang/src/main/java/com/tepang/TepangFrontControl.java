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
import com.tepang.control.AddReviewControl;
import com.tepang.control.BoardControl;
import com.tepang.control.BoardListControl;
import com.tepang.control.CartListControl;
import com.tepang.control.GetReviewCountControl;
import com.tepang.control.MainControl;
import com.tepang.control.MyHeartListControl;
import com.tepang.control.MyInfoUpdateControl;
import com.tepang.control.MyInfoControl;
import com.tepang.control.MyInfoDeleteControl;
import com.tepang.control.MyPageBoardControl;
import com.tepang.control.MyReviewControl;
import com.tepang.control.ProductDetailControl;
import com.tepang.control.ProductListControl;
import com.tepang.control.RemoveReviewControl;
import com.tepang.control.ReviewControl;
import com.tepang.control.SingupControl;
import com.tepang.control.TepangLoginControl;
import com.tepang.control.TepangLoginFormControl;
import com.tepang.control.TepangLogoutControl;
import com.tepang.control.TepangSingupFormControl;
import com.tepang.control.productCategoryListControl;
import com.tepang.control.userFvItemControl;

public class TepangFrontControl extends HttpServlet {

	Map<String, Control> map;

	public TepangFrontControl() {
		map = new HashMap<>(); // 필드의 값을 초기화.
	}

	@Override
	public void init(ServletConfig config) throws ServletException {


		map.put("/productDetail.do", new ProductDetailControl());// 상세목록
		
		//조성민
		map.put("/mainList.do", new MainControl());
		map.put("/productList.do", new ProductListControl());
		map.put("/productCategoryList.do", new productCategoryListControl());
		map.put("/userFvItem.do", new userFvItemControl());

		map.put("/cartList.do", new CartListControl());
		map.put("/boardList.do", new BoardListControl()); // 게시판목록
		map.put("/board.do", new BoardControl()); // 게시판목록 > 상세

		// 로그인 및 로그아웃 도한준
		map.put("/tepnagloginForm.do", new TepangLoginFormControl());
		map.put("/tepanglogin.do", new TepangLoginControl());
		map.put("/tepanglogout.do", new TepangLogoutControl());
		map.put("/tepnagsingupForm.do", new TepangSingupFormControl());
		map.put("/tepnagsingup.do", new SingupControl());
		
		// 마이페이지
		map.put("/myPage.do", new MyPageBoardControl()); // 마이페이지 상세
		map.put("/myinfo.do", new MyInfoControl()); 	// 정보확인
		map.put("/myinfoUpdate.do", new MyInfoUpdateControl()); // 정보 수정
		map.put("/myinfoDelete.do", new MyInfoDeleteControl()); // 회원탈퇴
		map.put("/myreview.do", new MyReviewControl()); // 나의 문의
		map.put("/myheartlist.do", new MyHeartListControl()); // 나의 찜목록
			
		// 리뷰
//		map.put("/replyList.do", new ListControl()); // 목록
//		map.put("/removeReply.do", new RemoveReplyControl()); // 삭제
//		map.put("/addReply.do", new AddReplyControl()); // 등록
//		map.put("/getConut.do", new GetReplyCountControl());

		// 리뷰
//		map.put("/replyList.do", new replyListControl()); // 목록
//		map.put("/removeReply.do", new RemoveReplyControl()); // 삭제
//		map.put("/addReply.do", new AddReplyControl()); // 등록
//		map.put("/getConut.do", new GetReplyCountControl());


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
