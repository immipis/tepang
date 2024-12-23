<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<head>

<style>
	#container{
		width: 1000px;
		margin: 0 auto;
		padding-top : 180px;
	}
	
	h4{
		padding-bottom: 30px;
	}
	
	p{		
		font-size: 14px;	
	}
	
	#form{
		margin_bottom: 30px;
	}

</style>

	<title>Home</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
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
					<div class="left-top-bar">
						안녕하세요
					</div>
					<div class="right-top-bar flex-w h-full">
						<a href="../tepanglogin.do" class="flex-c-m trans-04 p-lr-25">
							Sign In
						</a>
						<a href="#" class="flex-c-m trans-04 p-lr-25">
							Sign Up
						</a>
						<a href="./boardList.do" class="flex-c-m trans-04 p-lr-25">
							Board
						</a>
					</div>
				</div>
			</div>

			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">
					
					<!-- Logo desktop -->		
					<a href="#" class="logo">
						<img src="images/icons/logo-01.png" alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
					<input class="mtext-107 cl2 plh2 p-r-15 search-input" type="text" name="search-product"></input>
						<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11">
							<i class="zmdi zmdi-search"></i>
						</div>
					</div>	

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart" data-notify="4">
							<i class="zmdi zmdi-shopping-cart"></i>
						</div>

						<a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti" data-notify="9654">
							<i class="zmdi zmdi-favorite-outline"></i>
						</a>
					</div>
				</nav>
			</div>	
		</div>
	</header>
 
<div id = "container">
<h4>Board(boardList.jsp)</h4>
<p>안녕하세요 테팡입니다.<br>상품에 대해 궁금한것이 있으면 문의주세요.</p>
<button id="QABtn" class="col-sm-2 btn btn-primary"> 문의하기 </button>
<form action="boardList.do" id="form">
	<div class="row">
		<!-- sm-4 : 넓이  -->
		<div class="col-sm-3">
			<select name="searchCondition" class="form-control">
				<option value="T">제목</option>
				<option value="T"
					${!empty searchCondition and searchCondition eq 'T' ? 'selected' : '' }>제목</option>
				<option value="W"
					${searchCondition ne null && searchCondition == 'W' ? 'selected' : '' }>작성자</option>
				<option value="TW"
					${searchCondition ne null && searchCondition == 'TW' ? 'selected' : '' }>제목 & 작성자</option>
			</select>
		</div>
		<div class="col-sm-7">
			<input type="text" name="keyword" value= "${keyword ne null ? keyword : ''}" class="form-control">
		</div>
		<div class="col">
			<input type="submit" value="검색" class="form-control">
		</div>
	</div>
</form>
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
				<a href="board.do?page=${paging.currentPage }&keyword=${empty keyword ? '': keyword }&searchCondition=${empty searchCondition ? '' : searchCondition }&board_no=${bvo.boardNo}">${bvo.boardNo}</a>

				</td>
				<td><c:out value="${bvo.title}" /></td>
				<td><c:out value="${bvo.writer}" /></td>
				<td>${bvo.creationDate}</td>
			</tr>

		</c:forEach>
	</tbody>
</table>
<!-- paging -->


<!-- paging -->
<nav aria-label="...">
	<ul class="pagination">

		<!-- 이전 10개 목록이 존재하면 Previous를 활성화.  -->
	
		<c:choose>
			<c:when test="${paging.prev }">
				<li class="page-item">
				<a class="page-link" href="boardList.do?keyword=${keyword ne null ? keyword : ''}&searchCondition=${searchCondition ne null ? searchCondition : ''}&page=${paging.startPage -1 }">Previous</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><span class="page-link">Previous</span>
				</li>
			</c:otherwise>
		</c:choose>
	


		<!--startPage 와 endPage의 값에 해당하는 링크를 반복적으로 생성  -->

		<c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }">			
			<c:choose>
				<c:when test="${paging.currentPage == p }">
					<li class="page-item active" aria-current="page">
					<span class="page-link">${p }</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link"href="boardList.do?keyword=${keyword eq null ? '' : keyword }&searchCondition=${searchCondition eq null ? '' : searchCondition }&page=${p }">${p }</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		
		<!-- 이전 10개 목록이 존재하면 Previous를 활성화.  -->
		
		<c:choose>
			<c:when test="${paging.next }">
		<li class="page-item">
		<a class="page-link" href="boardList.do?keyword=${keyword ne null ? keyword : ''}&searchCondition=${!empty searchCondition ? '': searchCondition }&page=${paging.endPage +1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
				<span class="page-link">Next</span>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
</div>
</body>