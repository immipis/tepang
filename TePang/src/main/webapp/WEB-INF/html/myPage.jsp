<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>

<style>
	#mypage{
		margin:100px;
		
	}
	.menu{
	margin:70px;
	border:1px solid black;
	
	}
	.menu li{
	margin: 10px;
	display: inline-block;
	}
	.menu ul{
	display: inline-block;
	}
	.default{
	background-color:skyblue;
	color:white;
	}
</style>
	<title>My Tepang</title>
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
	<!-- Header -->
	<header>
		<!-- Header desktop -->
		<div class="container-menu-desktop">
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar">
						OOO 회원님 환영합니다 
					</div>
					<div class="right-top-bar flex-w h-full">
						<a href="../tepanglogin.do" class="flex-c-m trans-04 p-lr-25">
							Sign In
						</a>
						<a href="#" class="flex-c-m trans-04 p-lr-25">
							Sign Up
						</a>
						<a href="../boardList.do" class="flex-c-m trans-04 p-lr-25">
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
					<!-- 마이페이지 -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart" data-notify="4">
							<i class="zmdi zmdi-shopping-cart"></i>
						</div>

						<a href="./myPage.do" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti" data-notify="mt">
							<i class="zmdi zmdi-favorite-outline"></i>
						</a>
					</div>
				</nav>
			</div>	
		</div>
	</header>
<div id = "mypage">
 <h2>마이테팡(myPage.jsp)</h2>
 
 
 <div class="menu">
 <ul> <!-- 세로 정렬되게 (원래 세로인데 왜이럼) -->
 	<li class="default">구매목록(디폴트)</li>
 	<li>나의등급</li>
 	<li>내가 쓴 문의</li>
 	<li>찜한목록</li>
 	<li>내 정보 수정</li>
 	<li>회원탈퇴</li>
 </ul>

 </div>
</div> 
 </body>
