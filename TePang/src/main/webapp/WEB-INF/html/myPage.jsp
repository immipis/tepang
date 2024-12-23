<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

<style>
#container {
	width: 1000px;
	margin: 0 auto;
}

/* 사이드메뉴 */
.left-side {
	width: 15%;
	border-right: 2px solid #ddd;
	float: left;
	margin-top: 100px;
	margin-left:
}

.list-group {
	width: 100%;
	list-style: none;
	padding-right: 20px;
}

.list-group>li {
	height: 50px;
	font-size: 18px;
}

.list-group>li>a {
	color: black;
	text-decoration: none;
	display: flex;
	height: 100%;
	justify-content: center;
	align-items: center;
	border-bottom: 2px solid #ddd;
}

.list-group>li>a:hover {
	background-color: #ccc;
}
.buy{
	float:left;
	margin: 100px;
}
.td{
	padding:10px;
}
</style>
<title>My Tepang</title>
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
					<div class="left-top-bar">${member_id}회원님 환영합니다</div>
					<div class="right-top-bar flex-w h-full">
						<a href="../tepanglogin.do" class="flex-c-m trans-04 p-lr-25">
							Sign In </a> <a href="#" class="flex-c-m trans-04 p-lr-25"> Sign
							Up </a> <a href="../boardList.do" class="flex-c-m trans-04 p-lr-25">
							Board </a>
					</div>
				</div>
			</div>
			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">

					<!-- Logo desktop -->
					<a href="./mainList.do" class="logo"><img src="images/logo.png"
						alt="logo.png">
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
		<section class="left-side">

			<ul class="list-group">
				<li><a href="#">구매목록(디폴트)</a></li>
				<li><a href="#">내가 쓴 문의</a></li>
				<li><a href="#">찜 목록</a></li>
				<li><a href="#">내 정보 수정</a></li>
				<li><a href="#">회원탈퇴</a></li>
			</ul>
		</section>
	<section class="buy">
		<table>
			<tr>
				<td class="td">나의 구매목록</td>
			</tr>
			<tr>
				<td class="td"> ${member_id} 님의 등급은 Silver입니다.</td>
				
			</tr>
			<tr>
				<td class="td">회원님의 총 구매 금액은 ${ovo.orderSum} 입니다.</td>
			</tr>
			<tr>
				<td class="big">안녕하세요</td>
			</tr>
		</table>
		<table>
		
		</table>
	</section>
</body>
