<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							href="#">내 정보 수정</a> <a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="#!">Profile</a> <a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="#!">Status</a>
					</div>
				</div>
				<!-- Page content wrapper-->
				<!-- <div id="page-content-wrapper"> -->
					<!-- Top navigation-->

					<section class="leftmenu">
						<div class="info">
							<table>
								<tr>
									<td>${member_id}님의 등급은${member_tier}입니다.</td>
								</tr>
								<tr>
									<td>회원님의 총 구매 금액은 원 입니다.</td>
								</tr>
							</table>
						</div>					
					</section>
					<section>
					</section>
		</main>
	</div>
</body>

<!-- Footer -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>