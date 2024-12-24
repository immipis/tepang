<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<title>My Tepang</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<head>
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
<!--===============================================================================================-->
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
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
	<!-- Header -->
	<header>
		<script>
			let id = `${member_id}`
			console.log(id);
		</script>
		<!-- Header desktop -->

		<div class="container-menu-desktop">
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar">${member_id}님,환영합니다</div>

				</div>
			</div>
			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">

					<!-- Logo desktop -->
					<a href="./mainList.do" class="logo"><img src="images/logo.png"
						alt="logo.png"> </a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<input class="mtext-107 cl2 plh2 p-r-15 search-input" type="text"
							name="search-product"></input>
						<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11">
							<i class="zmdi zmdi-search"></i>
						</div>
					</div>

					<!-- Icon header -->
					<!-- 마이페이지 -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<div
							class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart"
							data-notify="4">
							<i class="zmdi zmdi-shopping-cart"></i>
						</div>

						<a href="./myPage.do"
							class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti"
							data-notify="mt"> <i class="zmdi zmdi-favorite-outline"></i>
						</a>
					</div>
				</nav>
			</div>
		</div>
	</header>


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

<jsp:include page="../includes/footer.jsp"></jsp:include>