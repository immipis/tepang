<%@page import="com.tepang.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
     <style>
		#container {
			width: 1000px;
			margin: 0 auto;
			padding-top: 180px;
		}
		.reply{
			padding: 30px; 
			margin-bottom: 80px;
			margin-top: 50px;
			background-color: #f1f1f1;
		
		}
	</style>
    
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.png" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css?after">
<link rel="stylesheet" type="text/css" href="css/main.css?after">
<!--===============================================================================================-->

</head>

<body>

	<header>
		<!-- Header desktop -->
		<div class="container-menu-desktop">
		
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar">안녕하세요</div>
					<div class="right-top-bar flex-w h-full">


                    <c:choose>
                    <c:when test="${not empty member_id }">
                      <a class="flex-c-m trans-04 p-lr-25" > ${member_id }</a>
                      <a class="flex-c-m trans-04 p-lr-25" href="myPage.do">마이 페이지</a>
                      <a class="flex-c-m trans-04 p-lr-25" href="tepanglogout.do">로그아웃</a>
                      <a href="./boardList.do" class="flex-c-m trans-04 p-lr-25"> Board </a>
                    </c:when>
                    <c:otherwise>

                      <a class="flex-c-m trans-04 p-lr-25" href="tepanglogin.do">로그인</a>
						<a href="#" class="flex-c-m trans-04 p-lr-25"> Sign Up </a> 

						<a href="./boardList.do" class="flex-c-m trans-04 p-lr-25"> Board </a>

                    </c:otherwise>
                    </c:choose>

						<a href="#" class="flex-c-m trans-04 p-lr-25"> Help & FAQs </a>


					</div>
				</div>
			</div>

			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">

					<!-- Logo desktop -->
					<a href="mainList.do" class="logo"> <img src="images/icons/logo-03.png"
						alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<input class="mtext-107 cl2 plh2 p-r-15 search-input" type="text"
							name="search-product"></input>
						<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11">
							<i class="zmdi zmdi-search"></i>
						</div>
					</div>

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<div
							class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart"
							data-notify="4">
							<i class="zmdi zmdi-shopping-cart"></i>
						</div>

						<a href="#"
							class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti"
							data-notify="9654"> <i class="zmdi zmdi-favorite-outline"></i>
						</a>
					</div>
				</nav>
			</div>
		</div>
	</header>
<!-- 헤더끝 -->
<div id = "container">
<h4>Board (board.jsp)</h4>
<form action="modifyForm.do">
	<input type="hidden" name="board_no" value="${reply_code}">
<!--	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
	<input type="hidden" name="page" value="${page}"> -->
	<p>${dlist}</p>
	<table class="table">
		<tr>
			<th>No</th>
			<td>${bvo.replyType}</td>
			<th>Writer</th>
			<td>${bvo.memberId}</td>
			<th>Date</th>
			<td>${bvo.replyDate}</td>			
		</tr>

		<tr>
			<th>문의 내용</th>
			<td><textarea rows="6" readonly class="form-control">${bvo.replyContent}</textarea></td>
		</tr> 	
	 	
	 	<!-- 로그인상태  => 권한에 따라 활성화/비활성화.
	 	 로그인 상태 아니면 => 권한 없음. --> 	
	 	<tr>	 	
		 	<td colspan="4" align="center">
		 	<c:choose>
			 	<c:when test="${logId ne null && board.writer == logId}">
			 		<input type="submit" class="btn btn-warning" value="수정화면" >
			 	</c:when>
			 	<c:otherwise>		 	
			 		<input type="submit" class="btn btn-warning" value="수정화면" disabled>
			 	</c:otherwise>
	 		</c:choose>
	 		</td>
	 	</tr>
	</table>
</form>
<!-- board.jsp 원래 있던 부분. -->

<!-- 댓글 시작 -->
<style>
	div.reply .content ul {
		list-style-type: none;
}
	div.reply .content span {
		display: inline-block;
}
</style>
<div class="reply">
	<div class="header">
		<b> re.답변 : </b>
		<!--<input type="text" id="reply" class="col-sm-7">
		<button id="addBtn" class="col-sm-2 btn btn-primary"> 댓글등록 </button> -->
	</div> <!-- 댓글등록 -->
	<div class="content">

		
				<span class="col-sm-2">writer : Tepang</span>

		<ul class="list"></ul>
	</div> <!-- 댓글목록 -->
	<div class="footer">
	
	<nav aria-label="Page navigation example">
  
</nav>
	
	</div> <!-- 댓글paging -->
</div>
</div>
<!-- 댓글 끝 -->
<script>
 let bno = "${board.boardNo}";
 let logId = "${logId}";
</script>
<script src="js/board.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
</script>
</body>
</html>
<jsp:include page="../includes/footer.jsp"></jsp:include>