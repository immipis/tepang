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

.leftmenu {
	width: 300px; 
	height: auto;
	margin: 50px;
	border: 1px solid blue;
}

.content {
	margin-left: 100px;
}

.plist {
	border: 1px solid blue;
	margin-top: 20px;
}

.pagination {
	margin-top: 180px;
}

.d-flex {
	margin-left: 100px;
}
</style>

<jsp:include page="../includes/header.jsp"></jsp:include>



<!-- 왼쪽 사이드 메뉴 -->
<div id=container>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">

			<div class="list-group list-group-flush">
					<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">구매목록(디폴트)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myreview.do">내가 쓴 문의(링크)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myheartlist.do">찜 목록(링크)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myinfo.do">내 정보 수정</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">보유쿠폰</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myinfoDelete.do">회원탈퇴</a> 
			</div>
		</div>
		<!-- Page content wrapper-->
		<!-- <div id="page-content-wrapper"> -->
		<!-- Top navigation-->
		<div class="content">
			<h5>${member_id}님, 안녕하세요.</h5>
			<h5>현재 ${member_id}님의 등급: ${memId.memberTier}</h5>
			<h2>구매목록</h2>
		</div>
	</div>
</div>
</body>

<!-- Footer -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>