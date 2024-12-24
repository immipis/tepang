<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#container {
	width: 1500px;
	margin: 0 auto;
	padding-top: 180px;
}

.user {
	width: 700px;
	height: auto;
	margin: 50px;
	border: 1px solid blue;
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
		<main>
			<div class="d-flex" id="wrapper">
				<!-- Sidebar-->
				<div class="border-end bg-white" id="sidebar-wrapper">

					<div class="list-group list-group-flush">
						<a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="#">구매목록(디폴트)</a> <a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="#">내가 쓴 문의</a> <a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="#">찜 목록</a> <a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="myInfo.do">내 정보 수정</a> <a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="#!">Profile</a> <a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="#!">Status</a>
					</div>
				</div>
				<!-- Page content wrapper-->
				<!-- <div id="page-content-wrapper"> -->
				<!-- Top navigation-->

				<section class="user">
					<div class="info">
						<table>
							<tr>
								<td>${member_id}님의등급은 ${memId.memberTier}입니다.</td>
							</tr>
							<tr>
								<td>회원님의 총 구매 금액은 원 입니다.</td>
							</tr>
						</table>
					</div>
					<div class="plist">
						<h3>구매 목록</h3>
						<table>
							<tr>
								<td></td>
							</tr>
						</table>
					</div>
				</section>
				
		</main>
	</div>
</body>

<!-- Footer -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>