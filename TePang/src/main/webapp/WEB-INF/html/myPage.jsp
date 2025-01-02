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
.pimg{
	width: 50px;
	height: 50px;
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
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myHeartList.do">찜 목록</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfo.do">내 정보 수정</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfoDeletePage.do">회원탈퇴</a> 
			</div>
		</div>
		<!-- Page content wrapper-->
		<!-- <div id="page-content-wrapper"> -->
		<!-- Top navigation-->
				<div class="content">
				<h2>구매목록</h2>		
				<div id="title">
			<p>${member_id} 님이 구매하신 상품 리스트입니다.</p>
			<table class="table">
				<thead>
					<tr>
						<th>주문번호</th>
						<th>받는 사람 이름</th>
						<th>상품 가격</th>
						<th>구매 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bvo" items="${list}">
					<tr>
						<td><c:out value="${bvo.orderNo}" /></td>
						<td align="center">
						${bvo.orderName}
						</td>
						<td>${bvo.orderSum} 원</td>
						<td>${bvo.orderDay}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		</div>
			
		</div>
</div>
</body>

<!-- Footer -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>