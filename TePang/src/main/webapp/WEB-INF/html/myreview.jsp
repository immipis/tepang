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
.content{
	margin-left: 70px;	
}
</style>

<jsp:include page="../includes/header.jsp"></jsp:include>
<div id=container>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">

			<div class="list-group list-group-flush">
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myPage.do">구매목록(디폴트)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">내가 쓴 문의(링크)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myheartlist.do">찜 목록(링크)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myinfo.do">내 정보 수정</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">보유쿠폰</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myinfoDelete.do">회원탈퇴</a> 
			</div>
		</div>
		<div class="content">
				<h2>내가 쓴 문의</h2>		
		</div>
	</div>
</div>
</body>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>