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
import com.tepang.control.BoardFormControl;
import com.tepang.control.BoardListControl;
import com.tepang.control.CartListControl;
import com.tepang.control.GetReviewCountControl;
import com.tepang.control.HeartListAddControl;
import com.tepang.control.InsertCartControl;
import com.tepang.control.MainCartControl;
import com.tepang.control.MainControl;
import com.tepang.control.MyHeartListControl;
import com.tepang.control.MyInfoControl;
import com.tepang.control.MyInfoDeletePageControl;
import com.tepang.control.MyInfoDropControl;
import com.tepang.control.MyInfoUpdateControl;
import com.tepang.control.MyInfoUpdatePageControl;
import com.tepang.control.MyPageBoardControl;
import com.tepang.control.MyReplyControl;
import com.tepang.control.MyReviewControl;
import com.tepang.control.PaymentControl;
import com.tepang.control.ProductDetailControl;
import com.tepang.control.ProductListControl;
import com.tepang.control.RemoveCartControl;
import com.tepang.control.RemoveReviewControl;
import com.tepang.control.ReviewControl;
import com.tepang.control.SingupControl;
import com.tepang.control.TepangLoginControl;
import com.tepang.control.TepangLoginFormControl;
import com.tepang.control.TepangLogoutControl;
import com.tepang.control.TepangSingupFormControl;
import com.tepang.control.UpdateCartControl;
import com.tepang.control.productCategoryListControl;
import com.tepang.control.searchControl;
import com.tepang.control.searchHistoryControl;
import com.tepang.control.userFvItemControl;

public class TepangFrontControl extends HttpServlet {

	Map<String, Control> map;

	public TepangFrontControl() {
		map = new HashMap<>(); // 필드의 값을 초기화.
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		//이신영
		map.put("/productDetail.do", new ProductDetailControl());// 상세목록
		
		//조성민
		map.put("/mainList.do", new MainControl());
		map.put("/productList.do", new ProductListControl());
		map.put("/productCategoryList.do", new productCategoryListControl());
		map.put("/userFvItem.do", new userFvItemControl());

		map.put("/cartList.do", new CartListControl()); // 장바구니 목록 출력.
		map.put("/updateCart.do", new UpdateCartControl()); // 장바구니 수량 변경.
		map.put("/removeCart.do", new RemoveCartControl()); // 장바구니 목록 삭제.
		map.put("/mainCart.do", new MainCartControl());
		map.put("/insertCart.do", new InsertCartControl()); // 장바구니 등록.
		map.put("/payment.do", new PaymentControl());
		map.put("/boardList.do", new BoardListControl()); // 게시판목록
		map.put("/board.do", new BoardControl()); // 게시판목록 > 상세
		map.put("/boardForm.do", new BoardFormControl()); //문의하기 폼

		// 로그인 및 로그아웃 도한준
		map.put("/tepnagloginForm.do", new TepangLoginFormControl());
		map.put("/tepanglogin.do", new TepangLoginControl());
		map.put("/tepanglogout.do", new TepangLogoutControl());
		map.put("/tepnagsingupForm.do", new TepangSingupFormControl());
		map.put("/tepnagsingup.do", new SingupControl());
		
		
		//검색기능 도한준 
		map.put("/search.do", new searchControl());
		map.put("/searchHistory.do", new searchHistoryControl());
		
		// 마이페이지 박혜원 
		map.put("/myPage.do", new MyPageBoardControl()); // 마이페이지 상세 (구매목록 리스트)
		map.put("/myReply.do", new MyReplyControl()); // 나의 문의 불러오기
		map.put("/myHeartList.do", new MyHeartListControl()); // 나의 찜목록 불러오기
		map.put("/myInfo.do", new MyInfoControl()); 	// 내 정보확인
		map.put("/myInfoUpdatePage.do", new MyInfoUpdatePageControl()); // 정보 수정 페이지 
		map.put("/myInfoUpdate.do", new MyInfoUpdateControl()); // 정보 수정 기능
		map.put("/myReview.do", new MyReviewControl()); // 내가 쓴 리뷰 불러오기
		map.put("/myInfoDeletePage.do", new MyInfoDeletePageControl()); // 회원탈퇴 페이지
		map.put("/infoDelete.do", new MyInfoDropControl()); // 회원탈퇴 기능
		map.put("/heartAdd.do", new HeartListAddControl()); // 찜추가 
		
        // 리뷰 이신영
		map.put("/review.do", new ReviewControl()); // 목록
		map.put("/removeReview.do", new RemoveReviewControl()); // 삭제
		map.put("/addReview.do", new AddReviewControl()); // 등록
		map.put("/getConut.do", new GetReviewCountControl()); //갯수


	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http://localhost:80/BoardWeb/boardList.do
		// http://localhost/TePang/productDetail.do?pcode=C2
		String uri = req.getRequestURI();
		//System.out.println(uri);
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		//System.out.println(path); // "/boardList.do" 공통부분을 제외한 나머지 부분.
		
		//  /productDetail.do?pcode=C2
		
		// 요청url === 실행할 컨트롤
		Control control = map.get(path);
		control.exec(req, resp);
	}
}
