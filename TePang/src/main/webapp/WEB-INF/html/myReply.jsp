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
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myPage.do">구매목록</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myReply.do">내가 쓴 문의</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myReview.do">내가 쓴 리뷰</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myHeartList.do">찜 목록</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfo.do">내 정보 수정</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfoDeletePage.do">회원탈퇴</a> 
			</div>
		</div>
		<div class="content">
				<h2>내가 쓴 문의</h2>		
				<div id="title">
			<p>${member_id} 님이 작성하신 문의 리스트입니다.</p>
			<table class="table">
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Writer</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bvo" items="${list}">
					<tr>
						<td align="center">
						${bvo.replyCode}
						</td>
						<td><c:out value="${bvo.replyContent}" /></td>
						<td><c:out value="${bvo.memberId}" /></td>
						<td>${bvo.replyDate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		</div>
	</div>
</div>
</body>
<script>
string replyType = $('replyType').text();
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>