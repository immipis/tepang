<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#container {
	width: 1500px;
	margin: 0 auto;
	padding-top: 180px;
	height: 800px;
}

.d-flex {
	margin-left: 100px;
}

.content {
	margin-left: 130px;
}

.notice {
	border: 1px solid black;
	padding: 30px;
	width: 800px;
	height: 250px;
}

.board {
	display: inline;
}

.pNotice {
	display: inline-block;
	float: right;
	margin-top: 20px;
	color: red;
}

.btn1 {
	margin-left: 20px;
	float: right;
}

.notice>ul>li {
	margin: 10px;
}
</style>
<jsp:include page="../includes/header.jsp"></jsp:include>
<!-- 왼쪽 사이드 메뉴 -->
<div id=container>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">

			<div class="list-group list-group-flush">
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myPage.do">구매목록</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myReply.do">내가 쓴 문의</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myReview.do">내가 쓴 리뷰</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myHeartList.do">찜 목록(미완)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfo.do">내 정보 수정</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfoDeletePage.do">회원탈퇴</a> 
			</div>
		</div>
		<!-- Page content wrapper-->
		<!-- <div id="page-content-wrapper"> -->
		<!-- Top navigation-->
		<div class="content">
			<h2>구매목록</h2>
			<br>
			<p>
				<strong>${member_id} 님의 구매 리스트</strong><br>
			</p>

			<br>
			<div class="notice">
				<ul>
					<li><h4>회원탈퇴 전, 유의사항을 확인해 주시기 바랍니다.</h4></li>
					<li>1) 회원탈퇴 시 회원전용 웹 서비스 이용이 불가합니다.</li>
					<li>2) 이미 결제가 완료된 건은 탈퇴로 취소되지 않습니다.</li>
					<li>3) 고객 정보 및 서비스 이용 기록은 개인정보 보호 처리 방침 기준에 따라 삭제됩니다.</li>
					<li>4) 회원 탈퇴 시 보유하고 계신 적립금은 회원 정보에 등록된 계좌로 3 ~ 7 영업일 이내에 자동
						이체됩니다.</li>
				</ul>
			</div>

	</div>
			
		</div>
</div>
</body>

<!-- Footer -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>